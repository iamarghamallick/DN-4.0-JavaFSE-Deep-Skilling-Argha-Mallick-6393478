CREATE TABLE employees (
  employee_id NUMBER PRIMARY KEY,
  department_id NUMBER,
  salary NUMBER
);

INSERT INTO employees VALUES (1, 10, 5000);
INSERT INTO employees VALUES (2, 10, 6000);
INSERT INTO employees VALUES (3, 20, 7000);
COMMIT;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  dept_id IN NUMBER,
  bonus_percent IN NUMBER
) IS
BEGIN
  UPDATE employees
  SET salary = salary + (salary * bonus_percent / 100)
  WHERE department_id = dept_id;

  COMMIT;
END;
/

BEGIN
  UpdateEmployeeBonus(10, 10);
END;
/
