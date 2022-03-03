using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            string username;
            string password;
            bool value;
            Class1 obj = new Class1();
            Console.WriteLine("Type login credentials");
            Console.WriteLine("Enter username");
            username = Console.ReadLine();
            Console.WriteLine("Enter Password");
            password = Console.ReadLine();
            value = obj.ValidateCredentails(username, password);
            if (value== true) {
                Console.WriteLine("Login Successfull");
            }
        }
    }
}
