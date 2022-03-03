use AdventureWorks

select *from Sales.Customer

select 'Credit Card ID' = CreditCardID, 'Credit Cart Type' = CardType,
'Credit Card Number' = CardNumber, 'Expiry year' = ExpYear
From Sales.CreditCard

select CustomerID, TerritoryID, AccountNumber
from Sales.Customer
where TerritoryID = 4

select *from Sales.SalesOrderDetail
where UnitPrice>2000

select *from Sales.SalesOrderDetail
where ProductID=843
--6
select *from Sales.SalesOrderDetail
where ModifiedDate = '2004-06-06'
--7
select 'order id'=SalesOrderID,'Order Quantity'=OrderQty,
'Unit Price'=UnitPrice, 'Total Cost'=OrderQty*UnitPrice
from Sales.SalesOrderDetail
--8
select * from Sales.SalesOrderDetail
where LineTotal
between 2000 and 2100
--9
select 'name'=Name, 'County region code'=CountryRegionCode,
'sales year date'=SalesYTD
from Sales.SalesTerritory
where TerritoryID=1
--10
Select * from Sales.SalesOrderHeader
where TaxAmt>10000
--11
select * from Sales.SalesTerritory
where Name = 'Canada' OR Name = 'France' OR Name = 'Germany'
 
--12
select 'sales Person Id'=SalesPersonID, 'Territory ID'=TerritoryID
from Sales.SalesPerson
where TerritoryID='2' OR TerritoryID='4'

--13
select *from Sales.CreditCard
where ExpYear='2006'​

--14
select * from Sales.SalesOrderHeader
where ModifiedDate>'2004-07-12'
--15
select 'order number'=SalesOrderID,'Order Date'=OrderDate,
'status'=Status, 'Total Cost'=SubTotal
from Sales.SalesOrderHeader
where OrderDate='2001-07-01'

---16
select * from Sales.SalesOrderHeader where OnlineOrderFlag=1
---17
select 'order Id'=SalesOrderID, 'Total Due'=TotalDue
from Sales.SalesOrderHeader
order by [Total Due] Desc


