CREATE TABLE Student(
	stdNo		CHAR(5) PRIMARY KEY,
	login		CHAR(6),
	lastName	VARCHAR(25),
	givenNames	VARCHAR(50),
	programCode	CHAR(4))

CREATE TABLE Course(
	courseID	CHAR(8) PRIMARY KEY,
	cName		VARCHAR(25),
	credits		INT DEFAULT 20 CHECK (credits>=0 AND credits<=200))

CREATE TABLE Semester(
	semesterID	INT PRIMARY KEY CHECK (semesterID>0),
	semester	INT CHECK (semester>=1 AND semester<=4),
	year		INT CHECK (year>=2000 AND year<=9999))

CREATE TABLE Register(
	stdNo		CHAR(5),
	courseID	CHAR(8),
	semesterID	INT CHECK (semesterID>0),
	grade		CHAR(2),
	mark		DECIMAL(5,2) DEFAULT 0.00 CHECK (mark>=0.00 AND mark<=100.00))

INSERT INTO Student VALUES
	('S0001', 'ABI723', 'Ingel', 'Abby Kate', 'BITC'),
	('S0210', 'KWE231', 'Kent', 'Robert', 'BSCS')

INSERT INTO Course VALUES
	('INFT2040', 'Database Management', 20),
	('INFT2132', 'Advanced Programming', 20),
	('INFT4001', 'Project', 40)

INSERT INTO Semester VALUES
	(1, 1, 2006),
	(2, 2, 2006),
	(3, 1, 2008)

INSERT INTO Register VALUES
	('S0001', 'INFT2040', 1, 'A', 98.02),
	('S0001', 'INFT2132', 2, 'B', 80.32),
	('S0210', 'INFT2132', 2, 'B+', 87.89),
	('S0210', 'INFT2040', 3, null, null)

SELECT * FROM Student
SELECT * FROM Course
SELECT * FROM Semester
SELECT * FROM Register
SELECT * FROM Register 
	WHERE mark = (SELECT MAX(mark) FROM Register)