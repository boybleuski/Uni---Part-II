CREATE TABLE	Account(
accNo		CHAR(12) PRIMARY KEY,
accountType	VARCHAR(20) NOT NULL,
customer	VARCHAR(100) NOT NULL,
Balance		DECIMAL(10,2));

INSERT INTO Account (accNo, accountType, customer, Balance) 
VALUES
('6123-1234567', 'Award Saver', 'Peter Wang', '12234.94'), 
('0231-2342142', 'Cheque', 'Mary Alison', '5342.98'), 
('8232-3231134', 'NetSaver', 'Ally Kent', '23112.33'),
('6123-1234568', 'Cheque', 'Peter Wang', '231.31');

SELECT * FROM Account;