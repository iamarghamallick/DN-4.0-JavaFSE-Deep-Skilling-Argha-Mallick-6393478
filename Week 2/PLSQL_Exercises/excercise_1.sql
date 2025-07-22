-- Exercise 1: Control Structures

-- Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.
-- o	Question: Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, apply a 1% discount to their current loan interest rates.

begin
   for rec in (
      select c.customerid,
             c.dob,
             l.loanid
        from customers c
        join loans l
      on c.customerid = l.customerid
   ) loop
      if months_between(
         sysdate,
         rec.dob
      ) / 12 > 60 then
         update loans
            set
            interestrate = interestrate - 1
          where loanid = rec.loanid;

         dbms_output.put_line('Discount applied for customer ' || rec.customerid);
      else
         dbms_output.put_line('No discount for customer ' || rec.customerid);
      end if;
   end loop;
end;
/

select *
  from loans;

-- Scenario 2: A customer can be promoted to VIP status based on their balance.
-- o	Question: Write a PL/SQL block that iterates through all customers and sets a flag IsVIP to TRUE for those with a balance over $10,000.

alter table customers add isvip varchar2(5) default 'FALSE';

select *
  from customers;

update accounts
   set
   balance = 15000
 where customerid = 1;

begin
   for rec in (
      select c.customerid,
             c.name,
             a.balance
        from customers c
        join accounts a
      on c.customerid = a.customerid
       where a.balance > 10000
   ) loop
      update customers
         set
         isvip = 'TRUE'
       where customerid = rec.customerid;

      dbms_output.put_line('Customer '
                           || rec.name
                           || ' has been promoted to VIP status.');
   end loop;
end;
/

select *
  from customers;

-- Scenario 3: The bank wants to send reminders to customers whose loans are due within the next 30 days.
-- o	Question: Write a PL/SQL block that fetches all loans due in the next 30 days and prints a reminder message for each customer.

select *
  from loans;

update loans
   set
   enddate = to_date('2025/08/20','YYYY/MM/DD')
 where loanid = 1;

begin
   for rec in (
      select l.loanid,
             c.name,
             l.enddate
        from loans l
        join customers c
      on l.customerid = c.customerid
       where l.enddate between sysdate and add_months(
         sysdate,
         1
      )
   ) loop
      dbms_output.put_line('Reminder: Loan '
                           || rec.loanid
                           || ' for customer '
                           || rec.name
                           || ' is due on '
                           || rec.enddate);
   end loop;
end;
/