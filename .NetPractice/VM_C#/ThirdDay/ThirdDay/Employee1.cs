using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ThirdDay
{
    class Employee1
    {
        private int Empid;
        private string Name;
        private string Department;
        private string Designation;
        public Employee1() {
            Department = "Cse";
            Designation = "Trainee";
        }

        public int Id
        {
            get {
                return Empid;
            }
            set {
                Empid = value;
            }
        }

        public string EName {
            get {
                return Name;
            }
            set {
                Name = value;
            }
        }
        public string EDesi
        {
            get
            {
                return Designation;
            }
            
        }
        public string EDept
        {
            get
            {
                return Department;
            }
           
        }

        public static void Main(string[] args) {
            Employee1 obj = new Employee1();
            obj.Id = 1;
            obj.EName = "a";
            //obj.EDesi = "b";
           // obj.EDept = "c";
            Console.WriteLine("EmpID:{0}",obj.Empid);
            Console.WriteLine("EmpName:{0}", obj.EName);
            Console.WriteLine("EmpDesi:{0}", obj.EDesi);
            Console.WriteLine("EmpDept:{0}", obj.EDept);
            Console.Read();
        }
    }
}
