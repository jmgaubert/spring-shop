INSERT INTO CUSTOMER (ID, NAME, PASSWORD,VERSION) VALUES ('123e4567-e89b-42d3-a456-556642440000', 'NAME1', 'PASS1',0);
INSERT INTO CUSTOMER (ID, NAME, PASSWORD,VERSION) VALUES ('223e4567-e89b-42d3-a456-556642440000', 'NAME2', 'PASS2',0);
INSERT INTO CUSTOMER (ID, NAME, PASSWORD,VERSION) VALUES ('323e4567-e89b-42d3-a456-556642440000', 'NAME3', 'PASS3',0);

INSERT INTO ITEM (ID, DESCRIPTION, PRICE,VERSION) VALUES ('123e4567-e89b-42d3-a456-556642440001', 'DESC1', 10,0);
INSERT INTO ITEM (ID, DESCRIPTION, PRICE,VERSION) VALUES ('123e4567-e89b-42d3-a456-556642440002', 'DESC2', 20,0);
INSERT INTO ITEM (ID, DESCRIPTION, PRICE,VERSION) VALUES ('123e4567-e89b-42d3-a456-556642440003', 'DESC3', 30,0);
INSERT INTO ITEM (ID, DESCRIPTION, PRICE,VERSION) VALUES ('123e4567-e89b-42d3-a456-556642440004', 'DESC4', 40,0);
INSERT INTO ITEM (ID, DESCRIPTION, PRICE,VERSION) VALUES ('123e4567-e89b-42d3-a456-556642440005', 'DESC5', 50,0);

INSERT INTO ORDERS (ID, CUSTOMER_ID,VERSION) VALUES ('123e4567-189b-42d3-a456-556642440000','123e4567-e89b-42d3-a456-556642440000',0);
INSERT INTO ORDERS (ID, CUSTOMER_ID,VERSION) VALUES ('123e4567-289b-42d3-a456-556642440000','123e4567-e89b-42d3-a456-556642440000',0);
INSERT INTO ORDERS (ID, CUSTOMER_ID,VERSION) VALUES ('123e4567-389b-42d3-a456-556642440000','323e4567-e89b-42d3-a456-556642440000',0);

INSERT INTO ORDERS_ITEMS (ITEMS_ID, ORDER_ID) VALUES ('123e4567-e89b-42d3-a456-556642440001','123e4567-189b-42d3-a456-556642440000');
INSERT INTO ORDERS_ITEMS (ITEMS_ID, ORDER_ID) VALUES ('123e4567-e89b-42d3-a456-556642440002','123e4567-189b-42d3-a456-556642440000');
INSERT INTO ORDERS_ITEMS (ITEMS_ID, ORDER_ID) VALUES ('123e4567-e89b-42d3-a456-556642440003','123e4567-289b-42d3-a456-556642440000');
INSERT INTO ORDERS_ITEMS (ITEMS_ID, ORDER_ID) VALUES ('123e4567-e89b-42d3-a456-556642440004','123e4567-289b-42d3-a456-556642440000');
INSERT INTO ORDERS_ITEMS (ITEMS_ID, ORDER_ID) VALUES ('123e4567-e89b-42d3-a456-556642440005','123e4567-389b-42d3-a456-556642440000');
INSERT INTO ORDERS_ITEMS (ITEMS_ID, ORDER_ID) VALUES ('123e4567-e89b-42d3-a456-556642440001','123e4567-389b-42d3-a456-556642440000');