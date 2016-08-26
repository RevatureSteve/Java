CREATE TABLE flash_cards
(
fc_id INT,
fc_question VARCHAR2(4000) UNIQUE,
fc_answer   VARCHAR2(4000),
PRIMARY KEY(fc_id)
);

--DML insert
INSERT INTO flash_cards VALUES (1, 'some question', 'some answer');
INSERT INTO flash_cards (fc_id, fc_question) VALUES(2, 'what is java?');

--DML select
SELECT fc_question q, fc_answer an FROM flash_cards;

--DML update
UPDATE flash_cards SET fc_answer = 'awesome' WHERE fc_question = 'what is java?';
UPDATE flash_cards SET fc_question = 'what is .net', fc_answer='allows us to C#' WHERE fc_id=1;

--DML delete
DELETE FROM flash_cards;

--PL/SQL sequences
CREATE SEQUENCE fc_seq 
  START WITH 1 
  INCREMENT BY 1;

CREATE OR REPLACE TRIGGER fc_seq_trigger
BEFORE INSERT ON flash_cards
FOR EACH ROW
BEGIN
--allowed to write PL/SQL
  --embedded SQL
  IF :new.fc_id IS NULL THEN
    
    SELECT fc_seq.nextval INTO :new.fc_id FROM DUAL;
    
  END IF;
END;
/

--CREATE [OR REPLACE] PROCEDURE proc_name [list of parameters]
--IS
--       *Declaration section*
--BEGIN
--       *Execution section*
--EXCEPTION
--       *Exception section*
--END;

--PROCEDURE hello world
CREATE OR REPLACE PROCEDURE hello_world_procedure
IS
BEGIN
  
  DBMS_OUTPUT.PUT_LINE('hello word!');
  
END;
/
--Find the View tab and select DBMS OUTPUT then in that new DBMS Output tab hit the green + and select the current db
BEGIN
  hello_world_procedure();
END;
/


CREATE OR REPLACE PROCEDURE insert_fc_procedure(some_q IN VARCHAR2, some_a IN flash_cards.fc_answer%TYPE, fc_error_msg OUT VARCHAR2)
IS
BEGIN
  
  INSERT INTO flash_cards(fc_question, fc_answer) VALUES(some_q, some_a);
   DBMS_OUTPUT.PUT_LINE('insert a flash card');
  COMMIT;
EXCEPTION
 WHEN OTHERS THEN
  fc_error_msg := SQLERRM;
END;
/

BEGIN
  
  insert_fc_procedure('Can we write stored procedures?', 'Absolutely!');
  
END;
/



CREATE OR REPLACE PROCEDURE get_answer_procedure(some_q IN VARCHAR2, some_a OUT VARCHAR2)
IS
BEGIN
  
  SELECT fc_answer INTO some_a FROM flash_cards WHERE fc_question = some_q;
 
END;
/

DECLARE
  answer VARCHAR2(4000);
BEGIN
  
  get_answer_procedure('Can we write stored procedures?', answer);
  DBMS_OUTPUT.PUT_LINE('answer: ' || answer);
  
END;
/


CREATE OR REPLACE PROCEDURE get_all_fc_procedure(cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN cursorParam FOR
  SELECT * FROM flash_cards;
END;
/

commit;
DECLARE
  fc_cursor SYS_REFCURSOR;
  someId flash_cards.fc_id%TYPE;
  someQ flash_cards.fc_question%TYPE;
  someA flash_cards.fc_answer%TYPE;
BEGIN
  
  get_all_fc_procedure(fc_cursor);
  
  
  LOOP
    FETCH fc_cursor INTO someId, someQ, someA;
    EXIT WHEN fc_cursor%NOTFOUND;
    
    DBMS_OUTPUT.PUT_LINE(someId || ' ' || someQ || ' ' || someA);
    
  END LOOP;
  
  CLOSE fc_cursor;
  
END;
/


CREATE OR REPLACE FUNCTION get_max_id
RETURN NUMBER
IS
  max_id NUMBER;
BEGIN
  
  SELECT MAX(fc_id) INTO max_id FROM flash_cards;
  RETURN max_id;
  
END;
/


DECLARE
  max_id NUMBER;
BEGIN
  
  max_id := get_max_id();
  
  DBMS_OUTPUT.PUT_LINE('max id is: ' || max_id);
  
END;
/

DECLARE
  firstNum  NUMBER;
  secondNum NUMBER;
  maxNum    NUMBER;

FUNCTION findMax(x IN NUMBER, y IN NUMBER)
RETURN NUMBER
IS
  z NUMBER;
BEGIN
  
  IF x > y THEN
    z := x;
  ELSE
    z := y;
  END IF;
  
  RETURN z;
 
END;

BEGIN
  firstNum  := 23;
  secondNum := 45;
  
  maxNum := findMax(firstNum, secondNum);
  
  DBMS_OUTPUT.PUT_LINE('Max of 23 and 45 is: ' || maxNum);

END;
/
UPDATE flash_cards 
SET FC_ANSWER = 43
, FC_QUESTION = 'hello' WHERE FC_ID = 5;


commit;
















