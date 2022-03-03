using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AbstractExp
{
    class Employee
    {
        int Empid;
        string Name;
        string dept;
        string desig;
        protected float basic;

        public void GetEmpDetails() {
            Console.WriteLine("Enter Id, Name,Dept,design");
            Empid = Convert.ToInt32(Console.ReadLine());
            Name = Console.ReadLine();
            dept = Console.ReadLine();
            desig = Console.ReadLine();
            Console.WriteLine("Enter salary");
            basic = Convert.ToSingle(Console.ReadLine());
        }
        public void DisplayEmpDetails()
          {
            Console.WriteLine("EMPID = {0}", Empid);
             Console.WriteLine("Name = {0}", Name);
               Console.WriteLine("Department = {0}", dept);
             Console.WriteLine("desig = {0}", desig);

           }
        public abstract void CalculateSalary();
    }
}
