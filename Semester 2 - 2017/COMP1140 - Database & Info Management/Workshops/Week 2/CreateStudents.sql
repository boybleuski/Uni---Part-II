CREATE TABLE	Student(
SID		CHAR(10) PRIMARY KEY,
Name	VARCHAR(50),
gpa		DECIMAL(3,2))

INSERT INTO Student (SID, Name, gpa) 
VALUES
('STD0001', 'John Taylor', '3.20'), 
('STD0021', 'Chris Boyle', '2.89'), 
('STD0501', 'Michelle Tang', '3.12');

SELECT * FROM Student