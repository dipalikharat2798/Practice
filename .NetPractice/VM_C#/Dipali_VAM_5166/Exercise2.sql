--18
Select SalesOrderID,TaxAmt
from Sales.SalesOrderHeader
--19
select SalesOrderNumber,SubTotal from Sales.SalesOrderHeader
order by SubTotal asc
--20
select Minimum= min(TotalDue), Maximum= max(TotalDue),
Average= avg(TotalDue) from Sales.SalesOrderHeader
--21
select 'Total value of order'=sum(TotalDue)
from Sales.SalesOrderHeader
--22
select Top 5 SalesOrderID
from Sales.SalesOrderHeader
where Datepart(yyyy,OrderDate)=2001 
order by TotalDue desc
--
select e.EmployeeID, d.GroupName,d.Name
From HumanResources.Employee e
join HumanResources.EmployeeDepartmentHistory h
on e.EmployeeID=h.DepartmentID
join HumanResources.Department d
on d.DepartmentID=h.DepartmentID
where d.DepartmentID=(
Select DepartmentID
From HumanResources.EmployeeDepartmentHistory
Where EmployeeID=1
)
----
use AdventureWorks
select * from Sales.SalesTerritory
select Name from Sales.SalesTerritory where Name like 'N%'

----
select * from Sales.SalesPerson
select TerritoryID,SalesQuota,SalesQuota
from Sales.SalesPerson where SalesQuota IS NOT NULL
-----
--26
select * from Sales.SalesOrderDetail
SELECT SalesOrderID,ProductID,SUM(LineTotal) 
FROM Sales.SalesOrderDetail GROUP BY SalesOrderID

--27
select ProductID,sum(LineTotal) as Total from Sales.SalesOrderDetail
Group by ProductID
Having sum(LineTotal)>10000
--28
SELECT ProductID, LineTotal AS 'Total' FROM Sales.SalesOrderDetail
COMPUTE on SUM(LineTotal) BY ProductID
GO
select * from Sales.SalesOrderDetail
select ProductID, SUM (LineTotal) as 'Total' 
from Sales.SalesOrderDetail
Group by cube (ProductID)

---29
select Top 3 * from Sales.SalesPerson

---30
select Name from Sales.Store where Name like '%bike%'

---31
select OrderDate, SUM(TotalDue)
From Sales.SalesOrderHeader
GROUP BY OrderDate

----32
select ProductID,sum(UnitPrice) as TotalUnitPrice,sum (LineTotal) as TotalAmount
from Sales.SalesOrderDetail
where ProductID in (777,774) group by cube(ProductID)

---33
select *From Sales.SalesOrderHeader
select SalesOrderID,MIN(LineTotal) as 'Minimum',MAX(LineTotal) as Maxinum
from Sales.SalesOrderDetail
where LineTotal>5000
group by SalesOrderID

---34
select SalesOrderID, AverageValue = avg(TotalDue)
from Sales.SalesOrderHeader
group by SalesOrderID
having sum(TotalDue) > 5000

---35
select distinct(CardType) from Sales.CreditCard

--36
select CustomerID, Name=left(Name,15), SalesPersonID from Sales.Store

--37
select SalesOrderNumber, TotalDue, 'DayofOrderWeek' = DateName(dw, OrderDate)
from Sales.SalesOrderHeader

--38
select SalesOrderID,OrderQty,UnitPrice,Dense_Rank()
Over(Order by UnitPrice ASC)
as
Rank from Sales.SalesOrderDetail

--39
select EmployeeID, Month = dateName(mm,HireDate), Year= datename(yyyy, HireDate) 
from HumanResources.Employee

--40
select LocationID, Name,CostRate,
Availability, ntile(3) over(order by CostRate desc)
as
Rank from Production.Location
Where CostRate>=12

--41
select 'The list Price of' + Name +'is' +
cast(ListPrice As Varchar(12)) As ListPrice
from Production.Product
where ListPrice Between 360.00 and 499.00
