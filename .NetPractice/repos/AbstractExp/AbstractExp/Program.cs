using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AbstractExp
{
    class Program
    {
        static void Main(string[] args)
{​​​​​

 char ch = 'y';
do
{​​​​​
Console.WriteLine("1.Manager");
Console.WriteLine("2.Trainee");
Console.WriteLine("select an option");
int choice = Convert.ToInt32(Console.ReadLine());
 Employee emp;
 switch (choice)
{​​​​​
case 1:
emp = new Manager();
emp.GetEmpDetails();
emp.CalculateSalary();
 break;
case 2:
emp = new Trainee();
emp.GetEmpDetails();
emp.CalculateSalary();
break;
 default:
 Console.WriteLine("invalid choice");
break;
}​​​​​
Console.WriteLine("Do want to continue");
ch = Convert.ToChar(Console.ReadLine());
}​​​​​
while (ch == 'y');
 Console.ReadLine();
}​​​​​
    }
}
