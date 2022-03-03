using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ThirdDay
{
    class Employee3
    {
        /*public Employee3()
        {
            EDept = "Cse";
            EDesig = "Trainee";
        }*/
        public int Id { get; set; }
    public string EName { get; set; }
        public string EDesig { get; set; } = "SoftEngg";
        public string EDept { get; set; } = "Trainee";

        public static void Main(string[] args)
        {
            Employee3 obj = new Employee3();
            obj.Id = 1;
            obj.EName = "a";
            //obj.EDesig = "b";
           // obj.EDept = "c";
            Console.WriteLine("EmpID:{0}", obj.Id);
            Console.WriteLine("EmpName:{0}", obj.EName);
            Console.WriteLine("EmpDesi:{0}", obj.EDesig);
            Console.WriteLine("EmpDept:{0}", obj.EDept);
            Console.Read();
        }
    }
}
