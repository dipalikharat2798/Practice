using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmpInheritance
{
    class Program
    {
        static void Main(string[] args)
        {
            char ch = 'y';
            do {
                Console.WriteLine("1. Manager");
                Console.WriteLine("2.Trainee");
                Console.WriteLine("Select an option");
                int choice = Convert.ToInt32(Console.ReadLine());

                switch (choice) {
                    case 1:
                        Manager m = new Manager();
                        m.AcceptDetails();
                        m.PrintPaySlip();
                        break;
                    case 2:
                        Trainee t = new Trainee();
                        t.AcceptDetails();
                        t.PrintPaySlip();
                        break;
                    default:
                        Console.WriteLine("Invalid choice");
                        break;
                }
                Console.WriteLine("Do you want to continue");
                ch = Convert.ToChar(Console.ReadLine());
            } while (ch=='y');
            Console.ReadLine();
        }
    }
}
