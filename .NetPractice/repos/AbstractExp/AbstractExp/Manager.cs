using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AbstractExp
{
    class Manager : Employee
{​​​​​
float hra, da, pf, tax, Gross;
public Manager()
{​​​​​
hra = 5000f;
da = 3000f;
pf = 1800f;
tax = 3500f;
}​​​​​


 public override void CalculateSalary()
{​​​​​
base.DisplayEmpDetails();
Gross = (base.basic + hra + da) - (pf + tax);
Console.WriteLine("Gross Salary = {​​​​​0}​​​​​", Gross);
}​​​​​
}​​​​​
}
