using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Person;
using Movie;
namespace MovieTicketProject
{
    class Program
    {
        public static int ReturnMethod()
        {
            int choice;
            Console.WriteLine();
            Console.WriteLine("\t*************************************************");
            Console.WriteLine("\t          MENU");
            Console.WriteLine("\t*************************************************");
            Console.WriteLine("1. Book Ticket");
            Console.WriteLine("2. View Price of Ticket");
            Console.WriteLine("3. Check Movie Timings");
            Console.WriteLine("4. Logout");
            Console.WriteLine();
            Console.WriteLine("\tSlect your Choice");
            choice = Convert.ToInt32(Console.ReadLine());
           
            return choice;
        }
        static void Main(string[] args)
        {
            Login obj1 = new Login();
            Movie1 Mobj = new Movie1();
            Timing Timeobj = new Timing();
            Ticket ticObj = new Ticket();
            bool Check1 = obj1.UserLog();
            int choice;
            
                if (Check1 == true)
                {
                    choice = ReturnMethod();
                switch (choice)
                {
                    case 1:
                        Console.WriteLine("\t-----------------------------------------------");
                        Console.WriteLine("\t         Here is your Movie List");
                        Console.WriteLine("\t-----------------------------------------------");
                        int i = Mobj.Playing();
                        int j = ReturnMethod();
                        if (j == 2) {
                            ticObj.Display();
                            int v = ReturnMethod();
                            if (v == 3) {
                                Timeobj.ShowTime();
                                int w = ReturnMethod();
                                if (w == 4) {
                                    Console.WriteLine("Thank you For Visiting");
                                    break;
                                }
                            }

                        }
                        break;

                   
                    default:
                        break;
                }
            }
            
        }
    }
}
