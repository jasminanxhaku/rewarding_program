ALTER TABLE Purchase_transaction ADD FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER (ID);


Insert into CUSTOMER values(1,'Mike');
Insert into CUSTOMER values(2,'Chris');
Insert into CUSTOMER values(3,'Brian');
Insert into CUSTOMER values(4,'Rando');
Insert into CUSTOMER values(5,'Shilpa');
Insert into CUSTOMER values(6,'Isaac');
Insert into CUSTOMER values(7,'Nos');
Insert into CUSTOMER values(8,'Michael');
Insert into CUSTOMER values(9,'Paul');

Insert into Purchase_transaction values(10001,1,110,'2022-12-03');
Insert into Purchase_transaction values(10002,1,60,'2022-01-27');
Insert into Purchase_transaction values(10003,1,40,'2022-11-26');

Insert into Purchase_transaction values(10004,2,170,'2022-10-13');
Insert into Purchase_transaction values(10005,2,30,'2022-12-01');
Insert into Purchase_transaction values(10006,2,110,'2022-11-15');

Insert into Purchase_transaction values(10007,3,75,'2022-11-11');
Insert into Purchase_transaction values(10008,3,180,'2022-11-30');
Insert into Purchase_transaction values(10009,3,90,'2022-10-28');

Insert into Purchase_transaction values(10010,4,80,'2022-10-29');
Insert into Purchase_transaction values(10011,4,45,'2022-12-13');
Insert into Purchase_transaction values(10012,4,115,'2022-12-04');

Insert into Purchase_transaction values(10013,5,120,'2022-11-24');
Insert into Purchase_transaction values(10014,5,175,'2021-11-16');
Insert into Purchase_transaction values(10015,5,20,'2022-12-10');

Insert into Purchase_transaction values(10016,6,190,'2022-12-09');
Insert into Purchase_transaction values(10017,6,25,'2022-11-25');
Insert into Purchase_transaction values(10018,6,160,'2022-12-17');

Insert into Purchase_transaction values(10019,7,75,'2022-09-30');
Insert into Purchase_transaction values(10020,7,100,'2022-11-23');
Insert into Purchase_transaction values(10021,7,180,'2022-11-26');

Insert into Purchase_transaction values(10022,8,140,'2022-10-31');
Insert into Purchase_transaction values(10023,8,95,'2022-12-12');
Insert into Purchase_transaction values(10024,8,30,'2022-12-05');

Insert into Purchase_transaction values(10025,9,105,'2022-12-01');
Insert into Purchase_transaction values(10026,9,90,'2022-12-07');
Insert into Purchase_transaction values(10027,9,55,'2022-11-27');
