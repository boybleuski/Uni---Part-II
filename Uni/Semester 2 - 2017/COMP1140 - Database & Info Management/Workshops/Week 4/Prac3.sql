DROP TABLE Student;
DROP TABLE Course;
DROP TABLE Semester;
DROP TABLE Register;

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
	mark		DECIMAL(3,2) DEFAULT 0.00 CHECK (mark>=0.00 AND mark<=100.00),
	PRIMARY KEY(stdNo, courseID, semesterID),
	FOREIGN KEY(stdNo) REFERENCES Student(stdNo) ON UPDATE CASCADE ON DELETE NO ACTION,
	FOREIGN KEY(courseID) REFERENCES Course(courseID) ON UPDATE CASCADE ON DELETE NO ACTION,
	FOREIGN KEY(semesterID) REFERENCES Semester(semesterID) ON UPDATE CASCADE ON DELETE NO ACTION

SELECT * FROM Student
SELECT * FROM Course
SELECT * FROM Semester
SELECT * FROM Register