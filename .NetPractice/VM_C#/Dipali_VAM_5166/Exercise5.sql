use AdventureWorks

SELECT sd.SalesOrderID, sum(LineTotal) AS [Total Amount]
FROM Sales.SalesOrderDetail sd JOIN Sales.SalesOrderHeader sh
ON sd.SalesOrderID = sh.SalesOrderID
GROUP BY sd.SalesOrderID

create CLUSTERED index index11
on Sales.SalesOrderHeader(SalesOrderID ASC) 

drop index index11
on Sales.SalesOrderHeader;

CREATE UNIQUE NONCLUSTERED INDEX Idx_CustomerID
 ON Sales.Store(CustomerID)  

select *into Sales.SalesOrderHeader1
 from Sales.SalesOrderHeader
 create CLUSTERED index index1
on Sales.SalesOrderHeader1(SalesOrderID ASC) 

--2

select *into Sales.Store1
 from Sales.Store


 create unique clustered index Clustone
 on Sales.Store1(CustomerID)  

 ---3


 create nonclustered Index
 Idx_salesOrderID_salesOrderDetailID
 on Sales.SalesOrderDetail(SalesOrderID,SalesOrderDetailID)


 ---4

CREATE VIEW vwSalesOrderDetail1
AS
SELECT oh.SalesOrderID, TerritoryID, TotalDue, OrderQty, ProductID
FROM Sales.SalesOrderHeader1 oh JOIN Sales.SalesOrderDetail od
ON oh.SalesOrderID = od.SalesOrderID

UPDATE vwSalesOrderDetail1

SET OrderQty = 2, TerritoryID = 4

FROM vwSalesOrderDetail1

WHERE SalesOrderID = 43659



UPDATE vwSalesOrderDetail1
SET OrderQty = 2
FROM vwSalesOrderDetail1
WHERE SalesOrderID = 43659


UPDATE vwSalesOrderDetail1
SET TerritoryID = 4
FROM vwSalesOrderDetail1
WHERE SalesOrderID = 43659  