using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ThirdDay
{
    class Employee 
    {
        int Empid;
        string Name;
        string Department;
        string Designation;
        public Employee()
        {
            Empid = 0;
            Name = null;
            Department = null;
            Designation = null;
            Console.WriteLine("Constructor created");
        }

            public Employee(int id, string name, string dept, string desi)
            {
                this.Empid = id ;
                this.Name = name;
                this.Department = dept;
                this.Designation = desi;
                Console.WriteLine("Constructor created");
                 DisplayDetails();
            }
          /* public void GetDetails() {
           Console.WriteLine("Enter id,Name,designation,department");
            Empid = Convert.ToInt32(Console.ReadLine());
            Name = Console.ReadLine();
            Department = Console.ReadLine();
            Designation = Console.ReadLine();

        }*/
        public void DisplayDetails() {
            Console.WriteLine("Empid : {0}" , Empid);
            Console.WriteLine("Name : {0}" , Name);
            Console.WriteLine("Designation : {0}", Designation);
            Console.WriteLine("Department : {0}", Department);
        }

         // GC.Collect();
           // void Dispose() {
           // GC.SuppressFinalize(this);
        //}
    }
}
