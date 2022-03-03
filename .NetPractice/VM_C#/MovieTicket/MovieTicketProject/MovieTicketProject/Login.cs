using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Person;
namespace MovieTicketProject
{
    public class Login
    {
        public string username { get; set; }
        public string password { get; set; }
        public  bool UserLog()
        {
            Console.WriteLine("\t-----------------------------------------------");
            Console.WriteLine("\t*************************************************");
            Console.WriteLine("\t          Movie Ticket Booking System");
            Console.WriteLine("\t-----------------------------------------------");
            Console.WriteLine("\t*************************************************");
            Console.WriteLine();
            Console.WriteLine("*Enter username : ");
            username = Console.ReadLine();
            Console.WriteLine("*Enter password : ");
            password = Console.ReadLine();

            Person1 obj = new Person1();

            if (obj.ValidateUser(username, password))
            {
                Console.WriteLine();
                Console.WriteLine("~ Welcome to the Royal Cinema "+username+" ~");
                return true;
            }
            else
            {
                Console.WriteLine("):-Login failure-:(");
                UserLog();
                return false;
            }
        }

    }
}
