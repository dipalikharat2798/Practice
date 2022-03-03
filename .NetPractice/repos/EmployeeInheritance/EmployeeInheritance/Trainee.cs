using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeInheritance
{
    class Trainee : Employee
    {
        float stipend;

        public void AcceptDetails()
        {
            base.GetEmpDetails();
            Console.WriteLine("Enter stipend");
            stipend = Convert.ToSingle(Console.ReadLine());

        }

        public void PrintPaySlip()
        {
            base.DisplayEmpDetails();

            Console.WriteLine("Gross Salary = {0}", stipend - 200);
        }
    }
}
