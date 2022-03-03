using System;

namespace EmployeeInheritance
{
    class Employee
    {
        int Empid;
        string Name;
        string dept;
        string desig;
        public void GetEmpDetails()
        {
            Console.WriteLine("Enter ID, Name, dept,design");

            Empid = Convert.ToInt32(Console.ReadLine());
            Name = Console.ReadLine();
            dept = Console.ReadLine();
            desig = Console.ReadLine();
        }
        public void DisplayEmpDetails()
        {
            Console.WriteLine("EMPID = {0}", Empid);
            Console.WriteLine("Name = {0}", Name);
            Console.WriteLine("Department = {0}", dept);
            Console.WriteLine("desig = {0}", desig);

        }
    }
}
