use VMDB2

CREATE PROCEDURE AddStudent
@Id int,
@Name varchar(50),
@Marks int
AS
BEGIN
insert into Student values(@Id,@Name,@Marks)
END
GO

CREATE PROCEDURE GetStudentByID
@Id int
AS
BEGIN
SELECT * from Student
where Id=@Id
END
GO

CREATE PROCEDURE GetAllStudents
AS
BEGIN
SELECT * from Student
END
GO

CREATE PROCEDURE DeleteStudentById
@Id int
AS
BEGIN
Delete from Student where Id=@Id
END
GO

CREATE PROCEDURE UpdateStudentById
@Id int,
@Marks int,
@Name varchar(50)
AS
BEGIN
update Student set Marks=@Marks ,Name=@Name
where ID=@Id
END
GO
select * from Student