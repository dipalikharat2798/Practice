DECLARE @Rate int
SELECT @Rate = max(Rate)
FROM HumanResources.EmployeePayHistory
PRINT @Rate
GO
use AdventureWorks
select *into HumanResources.EmployeePayHistory12
from HumanResources.EmployeePayHistory

DECLARE @Rate money
SELECT @Rate = Rate FROM
HumanResources.EmployeePayHistory1
WHERE EmployeeID = 23
IF @Rate < 15
PRINT 'Review of the rate is required'
ELSE
BEGIN
PRINT 'Review of the rate is not required'
PRINT 'Rate ='
PRINT @Rate
END
GO

SELECT EmployeeID, 'Marital Status' =
CASE MaritalStatus
WHEN 'M' THEN 'Married'
WHEN 'S' THEN 'Single'
ELSE 'Not specified'
END
FROM HumanResources.Employee
GO

WHILE (SELECT AVG(Rate)+1 FROM
HumanResources.EmployeePayHistory) < 20
BEGIN
UPDATE HumanResources.EmployeePayHistory12
SET Rate = Rate + 1
FROM HumanResources.EmployeePayHistory12
IF (SELECT max(Rate)+1 FROM
HumanResources.EmployeePayHistory12)>127
BREAK
ELSE
CONTINUE
END

use ValueMDB
begin try
insert into Emp(EmpName,DeptNo) values('k',2)
end try 
begin catch
SELECT 'There was an error! ' + ERROR_MESSAGE()
AS ErrorMessage,
ERROR_LINE() AS ErrorLine,
ERROR_NUMBER() AS ErrorNumber,
ERROR_PROCEDURE() AS ErrorProcedure,
ERROR_SEVERITY() AS ErrorSeverity,
ERROR_STATE() AS ErrorState
END CATCH
GO