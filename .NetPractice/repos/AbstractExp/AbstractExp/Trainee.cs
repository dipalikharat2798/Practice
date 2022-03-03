using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AbstractExp
{
    class Trainee : Employee
{​​​​​
public override void CalculateSalary()
{​​​​​
base.DisplayEmpDetails();

 Console.WriteLine("Gross Salary = {​​​​​0}​​​​​", base.basic - 200);
}​​​​​
}​​​​​
}
