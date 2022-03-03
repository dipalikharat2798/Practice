use ValueMDB
CREATE Table DeptDet(
DeptNo int Constraint deptno PRIMARY KEY ,
DeptName varchar(50)
) 
 CREATE TABLE EmpDet1(
EmpCode char(3) Constraint empcode Primary Key CHECK (EmpCode LIKE '[0-9][0-9][0-9]'),
DeptNo int CONSTRAINT frgnDeptNo REFERENCES DeptDet(DeptNo) ON DELETE Set Null ON UPDATE Set Null, 
Sal money CHECK (Sal BETWEEN 40000 AND 80000), 
Email varchar(50) CONSTRAINT Email unique,
Designation varchar(50) CONSTRAINT chk CHECK(Designation IN('Trainee','Manager')) CONSTRAINT chkDef DEFAULT 'Trainee' 
)
 