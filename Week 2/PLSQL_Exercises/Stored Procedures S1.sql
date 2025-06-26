CREATE TABLE savings_accounts (
  account_id NUMBER PRIMARY KEY,
  balance NUMBER
);

INSERT INTO savings_accounts VALUES (101, 1000);
INSERT INTO savings_accounts VALUES (102, 2500);
INSERT INTO savings_accounts VALUES (103, 4000);
COMMIT;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  FOR rec IN (SELECT account_id, balance FROM savings_accounts) LOOP
    UPDATE savings_accounts
    SET balance = balance + (balance * 0.01)
    WHERE account_id = rec.account_id;
  END LOOP;
  
  COMMIT;
END;
/

BEGIN
  ProcessMonthlyInterest;
END;
/
