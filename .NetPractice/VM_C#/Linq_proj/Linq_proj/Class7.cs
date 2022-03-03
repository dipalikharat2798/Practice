using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Linq_proj
{
    class Class7
    {

        static void Main(string[] args)
        {
            List<Employee> empList = new List<Employee>()
            {
                new Employee(){EmpId=101,EmpName="Scott",Salary=10000,Department="HR"},
                new Employee(){EmpId=102,EmpName="Shoaib",Salary=9000,Department="IT"},
                new Employee(){EmpId=103,EmpName="Sachin",Salary=11000,Department="Sales"},
                new Employee(){EmpId=104,EmpName="Rahul",Salary=8000,Department="IT"},
                new Employee(){EmpId=105,EmpName="Ilyas",Salary=12000,Department="HR"},
                new Employee(){EmpId=106,EmpName="Kashif",Salary=12000,Department="Fin"}
            };

            //select * from Employee

            var query1 = from emp in empList
                         select emp;
            Console.ForegroundColor = ConsoleColor.Red;
            Console.WriteLine("All employees:\n--------------");
            foreach (Employee emp in query1)
            {
                Console.WriteLine("{0, -4}{1, -7}{2, -6}{3, -6}", emp.EmpId, emp.EmpName, emp.Salary, emp.Department);
            }
            Console.ResetColor();

            // select , EmpName, Salary from Employee

            var query2 = from emp in empList
                         select new { EName = emp.EmpName, ESalary = emp.Salary };

            Console.ForegroundColor = ConsoleColor.Green;
            Console.WriteLine("All employees with EmpName and Salary:\n----------------------------");
            foreach (var emp in query2)
            {
                Console.WriteLine("{0, -7}{1, -7}", emp.EName, emp.ESalary);
            }
            Console.ResetColor();

            //select * from Employee order by EmpName acs
            //select * from Employee order by EmpName desc

            var query3 = from emp in empList
                         orderby emp.EmpName descending
                         select emp;
            Console.ForegroundColor = ConsoleColor.Blue;
            Console.WriteLine("All employees sorted by EmpName:\n----------------------------");
            foreach (var emp in query3)
            {
                Console.WriteLine("{0, -4}{1, -7}{2, -6}{3, -6}", emp.EmpId, emp.EmpName, emp.Salary, emp.Department);
            }
            Console.ResetColor();

            //select * from employee where salary > 10000

            var query4 = from emp in empList
                         where emp.Salary > 10000
                         select emp;
            Console.ForegroundColor = ConsoleColor.Magenta;
            Console.WriteLine("Salary > 10000:\n---------------------");
            foreach (var emp in query4)
            {
                Console.WriteLine("{0, -4}{1, -7}{2, -6}{3, -6}", emp.EmpId, emp.EmpName, emp.Salary, emp.Department);
            }
            Console.ResetColor();
            Console.ReadLine();

        }
    }
}
