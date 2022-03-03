use AdventureWorks
--1

SELECT SalesPersonID,Name FROM Sales.SalesPerson
JOIN Sales.SalesTerritory
ON SalesPerson.TerritoryID=SalesTerritory.TerritoryID

--2
SELECT 'Person ID'=SalesPersonID,
'Territory ID'=s1.TerritoryID,Name FROM Sales.SalesPerson s1
JOIN Sales.SalesTerritory s2
on s1.TerritoryID=s2.TerritoryID
----3
select 'Order ID'=s1.SalesOrderID,'Product ID'=s2.ProductID, 'Order Date'=s2.SalesOrderDetailID
from Sales.SalesOrderDetail s1 Join Sales.SalesOrderDetail s2
on s1.SalesOrderID= s2.SalesOrderID
----4
select SalesPersonID, s2.Name
from Sales.SalesPerson s1
left outer join Sales.SalesTerritory s2
on s1.TerritoryID=s2.TerritoryID
---5
SELECT SalesOrderID,'Territory Name'=Name,
Month=Datename(mm,OrderDate),
Year=Datename(yy,OrderDate)
FROM Sales.SalesOrderHeader s1
JOIN Sales.SalesTerritory s2
ON s1.TerritoryID=s2.TerritoryID

---6
SELECT SalesOrderID,'Territory Name'=Name,
OrderDate,Quarter=datepart(qq,OrderDate)
FROM Sales.SalesOrderHeader s1
JOIN Sales.SalesTerritory s2
ON s1.TerritoryID=s2.TerritoryID

----7
SELECT SalesOrderID,CardType,'Total Due'=Round(TotalDue,0) 
FROM Sales.SalesOrderHeader s1
JOIN Sales.CreditCard c1
ON s1.CreditCardID=c1.CreditCardID
----8
SELECT c1.CountryRegionCode,TerritoryID
FROM Sales.SalesTerritory s1
RIGHT OUTER JOIN Sales.CountryRegionCurrency c1
ON s1.CountryRegionCode=c1.CountryRegionCode
----9
SELECT 'Order VAlue'='The Total Amount Due For The Sales Order ID:  '+ Convert(Varchar(10),
SalesOrderID)+'is$'+Convert(Varchar(10),TotalDue) 
FROM Sales.SalesOrderHeader
----10
SELECT SalesOrderID,Name,Convert(Char(10),OrderDate,103 ) as 'Order Date' 
FROM Sales.SalesOrderHeader s1
JOIN Sales.SalesTerritory s2
ON s1.TerritoryID=s2.TerritoryID
----11
Select SalesOrderID,Name FROM Sales.SalesOrderHeader s1
JOIN Sales.SalesTerritory s2
ON s1.TerritoryID=s2.TerritoryID
WHERE DATENAME(mm,OrderDate)='May' AND DATEPART(yy,OrderDate)=2004
----12
Select ContactID,CardType FROM Sales.ContactCreditCard
JOIN Sales.CreditCard
ON ContactCreditCard.CreditCardID=CreditCard.CreditCardID
WHERE CardType='Vista'
---13
Select SalesOrderID FROM Sales.SalesOrderHeader 
WHERE TerritoryID=(Select TerritoryID FROM Sales.SalesTerritory WHERE Name='NorthEast')

----14
select salesOrderID, TotalDue
from sales.salesorderHeader
where totalDue > (select avg(TotalDue)
from sales.salesOrderheader)

---15
Select SalesOrderID,SalesOrderDetailID,LineTotal 
FROM Sales.SalesOrderDetail 
WHERE LineTotal> ALL(SELECT LineTotal FROM Sales.SalesOrderDetail WHERE SalesOrderID=43662)

---16
Select  SalesOrderID,CreditCardID 
FROM Sales.SalesOrderHeader
WHERE CreditCardID in (Select CreditCardID FROM Sales.CreditCard WHERE ExpYear=2007)

----17
select CardNumber from Sales.CreditCard
where CreditCardID=(select CreditCardID from Sales.ContactCreditCard where ContactID=
(select ContactID from Person.Contact where
FirstName='Catherine' and LastName='Abe1'))

---18
Select  *FROM Sales.SalesOrderDetail 
WHERE SpecialOfferID=(Select SpecialOfferID 
FROM  Sales.SpecialOffer WHERE  Type='No Discount')

---19
select SalesOrderDetailID,SalesOrderID,LineTotal 
from Sales.SalesOrderDetail s1
where s1.LineTotal > (select AVG(s2.LineTotal) from
Sales.SalesOrderDetail s2
where s1.SalesOrderID=s2.SalesOrderID)

---20
select SalesOrderID from Sales.SalesOrderHeader
where CreditCardID in (select CreditCardID
from Sales.CreditCard Where CardType='SuperiorCard')
---21
---23
WITH Sales_CTE (SalesPersonID,TotalSalesOrder) AS
(
     Select SalesPersonID, COUNT(SalesOrderID)
    FROM Sales.SalesOrderHeader WHERE     SalesPersonID IS NOT NULL
    GROUP BY SalesPersonID
)
Select SalesPersonID,TotalSalesOrder,
Commission=TotalSalesOrder*10
FROM Sales_CTE Order By TotalSalesOrder desc