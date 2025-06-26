DECLARE
  TYPE CustomerRec IS RECORD (
    customer_id NUMBER,
    balance NUMBER,
    isVIP BOOLEAN
  );

  TYPE CustomerTable IS TABLE OF CustomerRec INDEX BY PLS_INTEGER;
  customers CustomerTable;

BEGIN
  -- Sample data
  customers(1) := CustomerRec(1, 12000, FALSE);
  customers(2) := CustomerRec(2, 9000, FALSE);
  customers(3) := CustomerRec(3, 15000, FALSE);

  -- Processing
  FOR i IN 1 .. customers.COUNT LOOP
    IF customers(i).balance > 10000 THEN
      customers(i).isVIP := TRUE;
      DBMS_OUTPUT.PUT_LINE('Customer ' || customers(i).customer_id || ' is now a VIP.');
    END IF;
  END LOOP;
END;
