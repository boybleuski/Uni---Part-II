SELECT lastName, givenNames FROM Student WHERE programCode='BITC'
SELECT grade FROM Register WHERE stdNo='S0001' AND semesterID='1'
SELECT Course.courseID, Course.cName, Register.stdNo FROM Register WHERE stdNo='S0001' OR stdNo='S0210'
	INNER JOIN Course ON Register.courseID=Course.courseID;
SELECT Course.cName, Student.stdNo FROM Course WHERE stdNo='S0001' AND stdNo='S0210'
SELECT Course.cName, Student.stdNo FROM Course WHERE stdNo='S0001' AND NOT stdNo='S0210'
SELECT MAX(mark) FROM Register WHERE courseID='INFT2040'
SELECT COUNT(courseID) FROM Register WHERE stdNo='S0001' AND semesterID='3'
SELECT Student.stdNo, Student.lastName, Student.givenNames, Register.courseID, Register.grade
