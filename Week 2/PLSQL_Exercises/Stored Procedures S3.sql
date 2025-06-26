CREATE TABLE accounts (
  account_id NUMBER PRIMARY KEY,
  balance NUMBER
);

INSERT INTO accounts VALUES (201, 3000); -- from_account
INSERT INTO accounts VALUES (202, 1500); -- to_account
COMMIT;

CREATE OR REPLACE PROCEDURE TransferFunds (
  from_account IN NUMBER,
  to_account IN NUMBER,
  amount IN NUMBER
) IS
  insufficient_funds EXCEPTION;
BEGIN
  -- Check balance
  DECLARE
    source_balance NUMBER;
  BEGIN
    SELECT balance INTO source_balance FROM accounts WHERE account_id = from_account;

    IF source_balance < amount THEN
      RAISE insufficient_funds;
    END IF;

    -- Deduct from source
    UPDATE accounts
    SET balance = balance - amount
    WHERE account_id = from_account;

    -- Add to target
    UPDATE accounts
    SET balance = balance + amount
    WHERE account_id = to_account;

    COMMIT;
  END;
EXCEPTION
  WHEN insufficient_funds THEN
    DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient balance in account ' || from_account);
    ROLLBACK;
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Transfer failed due to unexpected error.');
    ROLLBACK;
END;
/

BEGIN
  TransferFunds(201, 202, 500);
END;
/
