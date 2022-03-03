using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FourthDay
{
    enum WeekDays { 
     Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Saturday,
        Sunday

    }
    class Class3
    {
        static void Main(string[] args)
        {
            int num;
            Console.WriteLine("enter the number ");
            num= Convert.ToInt32(Console.ReadLine());

            switch (num) {
             case 1:
                    Console.WriteLine(WeekDays.Monday);
            break;
             case 2:
                    Console.WriteLine(WeekDays.Tuesday);
                    break;
                case 3:
                    Console.WriteLine(WeekDays.Wednesday);
                    break;
                case 4:
                    Console.WriteLine(WeekDays.Thursday);
                    break;
                case 5:
                    Console.WriteLine(WeekDays.Friday);
                    break;
                case 6:
                    Console.WriteLine(WeekDays.Saturday);
                    break;
                case 7:
                    Console.WriteLine(WeekDays.Sunday);
                    break;
                default:
                    Console.WriteLine("Not Vallide");
                    break;
            }
            Console.ReadLine();
        }
    }
}
