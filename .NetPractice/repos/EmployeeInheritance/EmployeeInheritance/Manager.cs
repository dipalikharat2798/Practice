using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeInheritance
{
    class Manager : Employee
    {
        float hra, da, pf, tax, basic, Gross;
        public Manager()
        {
            hra = 5000f;
            da = 3000f;
            pf = 1800f;
            tax = 3500f;
        }

        public void AcceptDetails()
        {
            base.GetEmpDetails();
            Console.WriteLine("Enter salary");
            basic = Convert.ToSingle(Console.ReadLine());

        }

        public void PrintPaySlip()
        {
            base.DisplayEmpDetails();
            Gross = (basic + hra + da) - (pf + tax);
            Console.WriteLine("Gross Salary = {0}", Gross);
        }
    }
}
