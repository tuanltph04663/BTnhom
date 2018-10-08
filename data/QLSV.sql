USE MASTER
GO

IF EXISTS(SELECT * FROM  SYSDATABASES WHERE NAME='QLSV')
	
DROP DATABASE QLSV
GO

CREATE DATABASE QLSV
GO

USE QLSV
GO

CREATE TABLE loginfrom (
  usename varchar(150)  primary key,
  password varchar(150) ,
  role varchar(150) 
) 
--login
INSERT INTO loginfrom VALUES ('qlsv', '1', 'adminqlsv')
INSERT INTO loginfrom VALUES ('qld', '1', 'adminqld')

---- quan ly sinh vien
CREATE TABLE STUDENT (
    STUDENT_CODE VARCHAR(18) NOT NULL,
    FULL_NAME NVARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    PHONE_NUMBER VARCHAR(18) NOT NULL,
    GENDER NVARCHAR(18) NOT NULL,
    ADDRESS NVARCHAR(255) NOT NULL,
    IMAGE NVARCHAR(255) NOT NULL,
    PRIMARY KEY (STUDENT_CODE)
);

------

insert into STUDENT values('PH05318','LE THANH HIEN','hienlt@fpt.edu.vn','02847229381','Nam','Nhatrang','string')
insert into STUDENT values('PH05319','DO THI XUAN','xuandt@fpt.edu.vn','938479993','Nu','Hanoi','string')
insert into STUDENT values('PH05320','LE THANH TUAN','tuanlt@fpt.edu.vn','55304993821','Nam','nhatrang','string')
insert into STUDENT values('PH05321','LE THANH TU','tult@fpt.edu.vn','85937449204','Nu','Tay nguyen','string')
insert into STUDENT values('PH05322','CAO THAI SON','sonct@fpt.edu.vn','4829382732','Nam','Ho chi minh','string')

----bang diem
CREATE TABLE POINT (
    STUDENT_CODE VARCHAR(18) NOT NULL,
    FULL_NAME NVARCHAR(255) NOT NULL,
    ENGLISH float NOT NULL,
    INFORMATICS float NOT NULL,
    PHYSICAL_EDUCATION float NOT NULL,
    PRIMARY KEY (STUDENT_CODE)
);
--
-- Dumping data for table `grade`
--

INSERT INTO POINT VALUES('PH05318', 'LE THANH HIEN', 9, 10, 9)
INSERT INTO POINT VALUES('PH05319', 'DO THI XUAN', 10, 10, 10)
INSERT INTO POINT VALUES('PH05320', 'LE THANH TUAN', 10, 10, 9.5)
INSERT INTO POINT VALUES('PH05321', 'LE THANH TU', 10, 10, 5)
INSERT INTO POINT VALUES('PH05321', 'CAO THAI SON', 10, 10, 5)

