-- Exercise 2: Error Handling

-- Scenario 1: Handle exceptions during fund transfers between accounts.
-- o	Question: Write a stored procedure SafeTransferFunds that transfers funds between two accounts. Ensure that if any error occurs (e.g., insufficient funds), an appropriate error message is logged and the transaction is rolled back.

create or replace procedure safetransferfunds (
   p_from_account_id in number,
   p_to_account_id   in number,
   p_amount          in number
) as
   v_balance number;
begin
    -- Check if sufficient balance is available
   select balance
     into v_balance
     from accounts
    where accountid = p_from_account_id;

   if v_balance < p_amount then
      raise_application_error(
         -20001,
         'Insufficient funds'
      );
   end if;

    -- Debit from source
   update accounts
      set
      balance = balance - p_amount
    where accountid = p_from_account_id;

    -- Credit to destination
   update accounts
      set
      balance = balance + p_amount
    where accountid = p_to_account_id;

   commit;
   dbms_output.put_line('Transfer successful');
exception
   when others then
      rollback;
      dbms_output.put_line('Transfer failed: ' || sqlerrm);
end;
/

select *
  from accounts;

call safetransferfunds(
   1,
   2,
   15000
); -- (from, to, amount)

-- Scenario 2: Manage errors when updating employee salaries.
-- o	Question: Write a stored procedure UpdateSalary that increases the salary of an employee by a given percentage. If the employee ID does not exist, handle the exception and log an error message.

create or replace procedure updatesalary (
   p_emp_id     number,
   p_percentage number
) as
   v_curr_sal number;
begin
   select salary
     into v_curr_sal
     from employees
    where employeeid = p_emp_id;
   if v_curr_sal is null then
      raise_application_error(
         -20002,
         'Employee ID does not exist'
      );
   end if;
   update employees
      set
      salary = salary + ( salary * p_percentage / 100 )
    where employeeid = p_emp_id;
   commit;
   dbms_output.put_line('Salary updated successfully');
exception
   when others then
      rollback;
      dbms_output.put_line('Error updating salary: ' || sqlerrm);
end;
/

select *
  from employees;

call updatesalary(
   2,
   10
); -- (employee ID, percentage increase)

-- Scenario 3: Ensure data integrity when adding a new customer.
-- o	Question: Write a stored procedure AddNewCustomer that inserts a new customer into the Customers table. If a customer with the same ID already exists, handle the exception by logging an error and preventing the insertion.

create or replace procedure addnewcustomer (
   id   number,
   name varchar2,
   dob  date,
   bal  number
) is
begin
   insert into customers (
      customerid,
      name,
      dob,
      balance,
      lastmodified,
      isvip
   ) values ( id,
              name,
              to_date(dob,
                      'YYYY-MM-DD'),
              bal,
              sysdate,
              'false' );
   commit;
   dbms_output.put_line('Customer added successfully');
exception
   when others then
      dbms_output.put_line('Error adding customer: ' || sqlerrm);
end;
/

select *
  from customers;

call addnewcustomer(
   4,
   'Argha Mallick',
   to_date('2020/01/01',
               'YYYY/MM/DD'),
   1000
); -- (ID, Name, DOB, Balance)

commit;