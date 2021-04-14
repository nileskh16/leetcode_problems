CREATE TABLE IF NOT EXISTS PASSENGERS
(ID INT GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
NAME VARCHAR(50) NOT NULL,
COUNTRY VARCHAR(50) NOT NULL, PRIMARY KEY(ID));

INSERT INTO PASSENGERS (NAME, COUNTRY) VALUES ('Jim', 'US');
INSERT INTO PASSENGERS (NAME, COUNTRY) VALUES ('Jerry', 'US');
INSERT INTO PASSENGERS (NAME, COUNTRY) VALUES ('Tom', 'Germany');