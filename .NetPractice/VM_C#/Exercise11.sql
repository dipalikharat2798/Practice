--use AdventureWorks
SELECT e.EmployeeID,e.Title, eph.Rate,eph.PayFrequency ​

FROM HumanResources.Employee e   JOIN HumanResources.EmployeePayHistory eph     ON e.EmployeeID = eph.EmployeeID​

SELECT DISTINCT (p.ProductID), p1.SpecialOfferID, ​

p1.SalesOrderID, p1.OrderQty, p1.UnitPrice​

FROM Sales.SpecialOfferProduct p Full OUTER JOIN​

[Sales].[SalesOrderDetail] p1 ON p.ProductID  ​

=p1.ProductID ​

ORDER BY p.ProductID​

SELECT * FROM HumanResources.EmployeeDepartmentHistory d JOIN HumanResources.Employee e 
ON d.EmployeeID = e.EmployeeID JOIN HumanResources.Department p ON p.DepartmentID = d.DepartmentID​
 ​
ELECT emp.EmployeeID, emp.Title AS Employee_Designation, emp.ManagerID, mgr.Title AS Manager_Designation 
FROM HumanResources.Employee emp, HumanResources.Employee mgr WHERE emp.ManagerID = mgr.EmployeeID​

​​