DECLARE
  TYPE CustomerRec IS RECORD (
    customer_id NUMBER,
    age NUMBER,
    interest_rate NUMBER
  );

  TYPE CustomerTable IS TABLE OF CustomerRec INDEX BY PLS_INTEGER;
  customers CustomerTable;

BEGIN
  -- Sample data
  customers(1) := CustomerRec(1, 65, 8.5);
  customers(2) := CustomerRec(2, 45, 9.0);
  customers(3) := CustomerRec(3, 70, 7.5);

  -- Processing
  FOR i IN 1 .. customers.COUNT LOOP
    IF customers(i).age > 60 THEN
      customers(i).interest_rate := customers(i).interest_rate - 1;
      DBMS_OUTPUT.PUT_LINE('Customer ' || customers(i).customer_id ||
                           ' gets a discount. New rate: ' || customers(i).interest_rate || '%');
    END IF;
  END LOOP;
END;
