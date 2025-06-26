DECLARE
  TYPE LoanRec IS RECORD (
    loan_id NUMBER,
    customer_name VARCHAR2(50),
    due_date DATE
  );

  TYPE LoanTable IS TABLE OF LoanRec INDEX BY PLS_INTEGER;
  loans LoanTable;

BEGIN
  -- Sample data
  loans(1) := LoanRec(101, 'Alice', SYSDATE + 10);
  loans(2) := LoanRec(102, 'Bob', SYSDATE + 40);
  loans(3) := LoanRec(103, 'Charlie', SYSDATE + 5);

  -- Processing
  FOR i IN 1 .. loans.COUNT LOOP
    IF loans(i).due_date <= SYSDATE + 30 THEN
      DBMS_OUTPUT.PUT_LINE('Reminder: ' || loans(i).customer_name ||
                           ', your loan ID ' || loans(i).loan_id ||
                           ' is due on ' || TO_CHAR(loans(i).due_date, 'DD-Mon-YYYY'));
    END IF;
  END LOOP;
END;
