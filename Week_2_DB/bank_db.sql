
--DDL
CREATE TABLE bank_users (
bu_id int,
bu_username VARCHAR2(4000) UNIQUE,
bu_password VARCHAR2(4000),
PRIMARY KEY (bu_id)
);

CREATE TABLE bank_accounts(
ba_id int,
ba_balance DECIMAL(22,2),
bu_id int,
PRIMARY KEY(ba_id),
FOREIGN KEY(bu_id) REFERENCES bank_users(bu_id)
);

--DROP TABLE bank_accounts;
--DROP TABLE bank_users;

CREATE TABLE bank_tx_type(
btt_id int,
tx_type VARCHAR2(4000),
PRIMARY KEY(btt_id)
);

CREATE TABLE bank_tx (
bt_id int,
ba_id int,
btt_id int,
tx_amount DECIMAL(22,2),
tx_ts TIMESTAMP,
PRIMARY KEY (bt_id),
FOREIGN KEY (ba_id) REFERENCES bank_accounts(ba_id),
FOREIGN KEY (btt_id) REFERENCES bank_tx_type(btt_id)
);

--Create Sequences
CREATE SEQUENCE bu_seq
 START WITH 1
 INCREMENT BY 1;

CREATE SEQUENCE ba_seq
 START WITH 1
 INCREMENT BY 1;
 
CREATE SEQUENCE bt_seq
 START WITH 1
 INCREMENT BY 1;
 
 -------Triggers
 --BANK User trig
 CREATE OR REPLACE TRIGGER bu_seq_trigger
 BEFORE INSERT ON bank_users
 FOR EACH ROW 
 BEGIN
  SELECT bu_seq.nextval INTO :new.bu_id FROM DUAL;
END;

--Select * from DUAL; a dummy table
--Bank Account trig
CREATE OR REPLACE TRIGGER ba_seq_trigger
 BEFORE INSERT ON bank_accounts
 FOR EACH ROW
 BEGIN
  SELECT ba_seq.nextval INTO :new.ba_id FROM DUAL;
 END;
 
 --Bank Tx Trig
 CREATE OR REPLACE TRIGGER bt_seq_trigger
  BEFORE INSERT ON bank_tx
  FOR EACH ROW
  BEGIN
   SELECT bt_seq.nextval INTO :new.bt_id FROM DUAL;
  END;
 
--INSERT DATA
--tx-type doesn't have a seq or trigger
--must add primary key to insert statement
INSERT INTO bank_tx_type VALUES(1, 'DEPOSIT');
INSERT INTO bank_tx_type VALUES(2, 'WITHDRAW');
 
INSERT INTO bank_users(BU_USERNAME,BU_PASSWORD) VALUES ('john','123');
INSERT INTO bank_users(BU_USERNAME,BU_PASSWORD) VALUES ('amy','456');
INSERT INTO bank_users(BU_USERNAME,BU_PASSWORD) VALUES ('austin','768');
INSERT INTO bank_users(BU_USERNAME,BU_PASSWORD) VALUES ('katie', '000');
INSERT INTO bank_users(BU_USERNAME,BU_PASSWORD) VALUES ('courtney','p4ssw0rd');

/*
BA_ID --ommited to sequence
BA_BALANCE -must add
BU_ID -- must add
*/
INSERT INTO bank_accounts(BU_ID, BA_BALANCE) VALUES(1, 123.45);
INSERT INTO bank_accounts(BU_ID, BA_BALANCE) VALUES(2, 2000.09);
INSERT INTO bank_accounts(BU_ID, BA_BALANCE) VALUES(3, 500);
INSERT INTO bank_accounts(BU_ID, BA_BALANCE) VALUES(4, 10000.999);
INSERT INTO bank_accounts(BU_ID, BA_BALANCE) VALUES(5, 6.5);

/*
BT_ID
BA_ID
BTT_ID
TX_AMOUNT
TX_TS 
*/
--BANK TX INSERT
--INSERT INTO bank_tx VALUES(1, 1, 1, 50,'20-AUG-16 07.17.54.098000000 PM');
INSERT INTO bank_tx(ba_id, btt_id, tx_amount) VALUES(1,1,20);
INSERT INTO bank_tx(ba_id, btt_id, tx_amount) VALUES(1,2,40.5);
INSERT INTO bank_tx(ba_id, btt_id, tx_amount) VALUES(2,1,100);
INSERT INTO bank_tx(ba_id, btt_id, tx_amount) VALUES(3,1,23.45);
INSERT INTO bank_tx(ba_id, btt_id, tx_amount) VALUES(4,2,5000.55);

--DISPLAY
SELECT * FROM bank_users;
SELECT bu_username from bank_users;
SELECT bu_username FROM bank_users WHERE bu_username = 'john'; --WHERE
SELECT bu_username FROM bank_users WHERE bu_username LIKE 'a%'; --% wild

SELECT bu_username FROM bank_users WHERE ROWNUM <= 2; --only in oracle no limit

SELECT * FROM bank_tx;
SELECT * FROM bank_tx WHERE tx_amount BETWEEN 23.45 AND 100;

--INNER JOIN
SELECT bu.bu_username AS "username", bt.tx_amount AS "Amount", btt.tx_type AS "Action", bt.tx_ts AS "Occured"
FROM bank_tx bt
INNER JOIN bank_accounts ba ON bt.ba_id = ba.ba_id 
INNER JOIN bank_tx_type btt ON btt.btt_id = bt.btt_id
INNER JOIN bank_users bu    ON bu.bu_id = ba.bu_id;


--Shows Katie
SELECT bu.bu_username AS "username", bt.tx_amount AS "Amount", btt.tx_type AS "Action", bt.tx_ts AS "Occured"
FROM bank_tx bt
INNER JOIN bank_accounts ba ON bt.ba_id = ba.ba_id 
INNER JOIN bank_tx_type btt ON btt.btt_id = bt.btt_id
RIGHT JOIN bank_users bu    ON bu.bu_id = ba.bu_id;




