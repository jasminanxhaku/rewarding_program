DROP TABLE IF EXISTS customer;
  
CREATE TABLE customer (
  id INT PRIMARY KEY,
  name VARCHAR(150) NOT NULL);


DROP TABLE IF EXISTS purchase_transaction;
  
CREATE TABLE purchase_transaction (
  id INT PRIMARY KEY,
  customer_id INT,
  transaction_amount INT,
  creation_date DATE  
);

