-- Exercise 3: Stored Procedures

-- Scenario 1: The bank needs to process monthly interest for all savings accounts.
-- o	Question: Write a stored procedure ProcessMonthlyInterest that calculates and updates the balance of all savings accounts by applying an interest rate of 1% to the current balance.

create or replace procedure processmonthlyinterest is
begin
   update accounts
      set
      balance = balance + ( balance * 0.01 )
    where lower(accounttype) = 'savings';
   commit;
end;
/

select *
  from accounts;

call processmonthlyinterest();

-- Scenario 2: The bank wants to implement a bonus scheme for employees based on their performance.
-- o	Question: Write a stored procedure UpdateEmployeeBonus that updates the salary of employees in a given department by adding a bonus percentage passed as a parameter.

create or replace procedure updateemployeebonus (
   p_department       varchar2,
   p_bonus_percentage number
) is
begin
   update employees
      set
      salary = salary + ( salary * p_bonus_percentage / 100 )
    where department = p_department;
end;
/

select *
  from employees;

call updateemployeebonus(
   'IT',
   10
);

-- Scenario 3: Customers should be able to transfer funds between their accounts.
-- o	Question: Write a stored procedure TransferFunds that transfers a specified amount from one account to another, checking that the source account has sufficient balance before making the transfer.

create or replace procedure transferfunds (
   p_from_acc number,
   p_to_acc   number,
   p_amount   number
) is
   v_bal number;
begin
   select balance
     into v_bal
     from accounts
    where accountid = p_from_acc;

   if v_bal < p_amount then
      raise_application_error(
         -1234,
         'Insuffucient Balance!'
      );
   end if;
   update accounts
      set
      balance = balance - p_amount
    where accountid = p_from_acc;

   update accounts
      set
      balance = balance + p_amount
    where accountid = p_to_acc;
end;
/

select *
  from accounts;

call transferfunds(
   1,
   2,
   49
);

commit;