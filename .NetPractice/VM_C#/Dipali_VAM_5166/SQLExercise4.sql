create table Recipient(
OrderNumber char(6),
FirstName varchar(20),
LastName varchar(20),
Address varchar(50),
City char(15),
State char(15),
CountryCode char(3),
ZipCode char(10),
Phone char(15)
)

create table Country(
CountryID varchar(2),
Country char(25)
)

alter table Country
alter Column CountryID char(3)


truncate Table Recipient

create table Newproduct(
ProductID char(6) constraint pkey Primary key,
ProductName varchar(20) not null,
ProductDescription varchar(250) not null,
CategoryID char(3),
ProductRate money,
BrandID char(3),
Qoh smallint constraint chkQoh check(Qoh between 0 and 200),
)

create table Category(
CategoryID char(3) constraint prikey primary key,
Category char(20) Unique,
Description varchar(100) null
)

create table ProductBrand(
BrandID char(3)constraint ppkey primary key,
BrandName char(20) unique
)

alter table NewProduct
add foreign key(BrandID) references ProductBrand(BrandID)

--delete table Category









CREATE TABLE EmpDet(
EmpCode char(4) Constraint empcode Primary Key CHECK (EmpCode LIKE '[AZ][0-9][0-9][0-9]'),
DeptNo int CONSTRAINT fkDeptNo REFERENCES
DeptDet(DeptNo)
ON DELETE Set Null ON UPDATE Set Null, Sal money CHECK (Sal BETWEEN 40000 AND 80000),
Email varchar(50) CONSTRAINT ckEmail unique,
Designation varchar(50) CONSTRAINT chk
CHECK(Designation IN('Trainee','Manager')) CONSTRAINT
chkDef DEFAULT 'Trainee' 
)
create table OfficeLocation1(
Office_ID int not null,
Office_Manger varchar(30) not null,
Office_Location geography not null
)

--alter table OfficeLocation1
--add Office_Manager varchar(30) not null
--add Office_Location geography not null

create table PictureDetails(
EventPIcID  UNIQUEIDENTIFIER ROWGUIDCOL not null,
EventName varchar(30) not null,
)