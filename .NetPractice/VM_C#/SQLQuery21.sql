use ValueMDB
CREATE TABLE [dbo].[Employee](
	[ID] [int] primary key,
	[Name] [varchar](50) NULL,
	[Gender] [varchar](10) NULL,
	[Salary] [float] NULL,
	[Country] [varchar](50) NULL
	)

SELECT Country, Gender, SUM(Salary) AS TotalSalary
FROM Employee
GROUP BY Cube(Country, Gender)

--OR

SELECT Country, Gender, SUM(Salary) AS TotalSalary
FROM Employee
GROUP BY Country, Gender with Cube

SELECT Country, Gender, SUM(Salary) AS TotalSalary
FROM Employee
GROUP BY Country, Gender

UNION ALL 

SELECT Country, NULL, SUM(Salary) AS TotalSalary
FROM Employee
GROUP BY Country

UNION ALL

SELECT NULL, Gender, SUM(Salary) AS TotalSalary
FROM Employee
GROUP BY Gender

UNION ALL

SELECT NULL, NULL, SUM(Salary) AS TotalSalary
FROM Employee

------------------------------------------------------
--rollup

SELECT Country, SUM(Salary) AS TotalSalary
FROM Employee
GROUP BY ROLLUP(Country)

--The above query can also be rewritten as shown below
SELECT Country, SUM(Salary) AS TotalSalary
FROM Employee
GROUP BY Country WITH ROLLUP

--We can also use UNION ALL operator along with GROUP BY
SELECT Country, SUM(Salary) AS TotalSalary
FROM Employee
GROUP BY Country

UNION ALL

SELECT NULL, SUM(Salary) AS TotalSalary
FROM Employee

--We can also use Grouping Sets to achieve the same result
SELECT Country, SUM(Salary) AS TotalSalary
FROM Employee
GROUP BY GROUPING SETS
(
    (Country),
    ()
)

--Using ROLLUP with GROUP BY
SELECT Country, Gender, SUM(Salary) AS TotalSalary
FROM Employee
GROUP BY ROLLUP(Country, Gender)

--OR

SELECT Country, Gender, SUM(Salary) AS TotalSalary
FROM Employee
GROUP BY Country, Gender WITH ROLLUP

--Using UNION ALL with GROUP BY
SELECT Country, Gender, SUM(Salary) AS TotalSalary
FROM Employee
GROUP BY Country, Gender

UNION ALL

SELECT Country, NULL, SUM(Salary) AS TotalSalary
FROM Employee
GROUP BY Country

UNION ALL

SELECT NULL, NULL, SUM(Salary) AS TotalSalary
FROM Employee

--Using GROUPING SETS
SELECT Country, Gender, SUM(Salary) AS TotalSalary
FROM Employee
GROUP BY GROUPING SETS
(
    (Country, Gender),
    (Country),
    ()
)
