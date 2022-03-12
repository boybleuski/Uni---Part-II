-- LIBRARY DATABASE SCRIPT

drop table Loan
drop table Member
drop table Book
drop table MemberType


-- BOOK TABLE
CREATE TABLE Book(
accNo				CHAR(10) PRIMARY KEY,  	-- accession number
title				VARCHAR(200),			-- title of book
authors				VARCHAR(250),			-- authors of book
isbn				CHAR(20)				-- isbn number of book
)

-- MEMBERTYPE TABLE
CREATE TABLE MemberType (
code				CHAR(4) PRIMARY KEY,	-- Member type identifier
memberTypeDetails	VARCHAR(100),			-- Member type description
maxBooks			INT						-- Number of books that can be borrowed at once by member tyoe
)

-- MEMBER TABLE
CREATE TABLE Member (
memberNo			CHAR(10) PRIMARY KEY,			-- Member number
memberName			VARCHAR(250),					-- Name of member
mType				CHAR(4),						-- Member type
FOREIGN KEY(mType) REFERENCES MemberType(code) ON UPDATE CASCADE ON DELETE NO ACTION,
)

-- LOAN TABLE
CREATE TABLE Loan (
accNo				CHAR(10),						-- Accession number
memberNo			CHAR(10),						-- Member number
dateBorrowed		DATETIME	DEFAULT GETDATE(),	-- Date and time borrowed	
dueDate				DATETIME,						-- Due date of book 
dateReturned		DATETIME,						-- Date book is returned
PRIMARY KEY(accNo, memberNo, dateBorrowed),
FOREIGN KEY(accNo) REFERENCES Book(accNo) ON UPDATE CASCADE ON DELETE NO ACTION,
FOREIGN KEY(memberNo) REFERENCES Member(memberNo) ON UPDATE CASCADE ON DELETE NO ACTION
)
go



-- LOADING SAMPLE DATA
-- LOADING TO Book TABLE
INSERT INTO Book VALUES ('A110034567', 'Database Management Systems', 
	'Ramakrishnan, Gehrke', 'ISD-00123-0211-09287')
INSERT INTO Book VALUES ('A110233444', 'The UML User Guide', 
	'Booch, Rumbaugh, Jacobson', 'ISD-00123-02231-0923')
INSERT INTO Book VALUES ('A112344567', 'Teach Yourself C++', 
	'Al Stevens', 'ISD-00123-0211-008')
INSERT INTO Book VALUES ('A123234567', 'Oracle 9i: The Complete Reference', 
	'Loney, Koch', 'ISD-00123-0231-0928')
	INSERT INTO Book VALUES ('A133234567', 'Access 2003 VBA', 
	'Cardoza, Hennig, Seach, Stein', 'ISD-00123-0322-1947')
	INSERT INTO Book VALUES ('A133234570', 'Excel 2010 VBA For Dummies', 
	'Wije, Simon, Stein', 'ISD-00123-0321-2017')
go

-- LOADING TO MemberType TABLE
INSERT INTO MemberType VALUES ('USTD', 'Undergraduate Student', 2)
INSERT INTO MemberType VALUES ('GSTD', 'Graduate Student', 4)
INSERT INTO MemberType VALUES ('FACL', 'Faculty Member', 10)
INSERT INTO MemberType VALUES ('VSAC', 'Visiting Academic', 5)
go

-- LOADING TO Member TABLE
INSERT INTO Member VALUES ('M123456789', 'Chris Davies', 'USTD')
INSERT INTO Member VALUES ('M12333789', 'Angalie Patterson', 'USTD')
INSERT INTO Member VALUES ('M12234789', 'Mohammed Muftaz', 'USTD')
INSERT INTO Member VALUES ('M123256789', 'Upul Wijesinghe', 'GSTD')
INSERT INTO Member VALUES ('F123456789', 'Young Black', 'FACL')
INSERT INTO Member VALUES ('F123333789', 'Joe Dennis', 'FACL')
go

-- LOADING TO Loan TABLE
INSERT INTO Loan VALUES ('A110034567', 'M123456789', '23-APR-2013', '23-JUN-2013', null)
INSERT INTO Loan VALUES ('A110034567', 'F123456789', '25-MAY-2012', '25-OCT-2012', '20-OCT-2012')
INSERT INTO Loan VALUES ('A112344567', 'M123456789', '28-FEB-2014', '31-MAY-2014', null)
INSERT INTO Loan VALUES ('A112344567', 'F123456789', '25-MAY-2012', '25-OCT-2012', '24-OCT-2012')
INSERT INTO Loan VALUES ('A123234567', 'F123456789', '28-FEB-2014', '31-MAY-2014', '30-MAR-2014')
INSERT INTO Loan VALUES ('A133234567', 'M123456789', '27-FEB-2014', '30-MAY-2014', null)


go
