using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MovieTicketProject
{
   public class Timing 
    {
        public void ShowTime() {
            int i;
            Console.WriteLine("Select Movie for which you want to know Timing");
            Console.WriteLine("1.\"Dangal\" ");
            Console.WriteLine("2.\"2.0\" ");
            Console.WriteLine("3.\"Airlift\"");
            Console.WriteLine("4.\"K.G.F: Chapter 2\" ");

            i = Convert.ToInt32(Console.ReadLine());
            switch (i) {
                case 1:
                    Console.WriteLine("2 hr 20min");
                    break;
                case 2:
                    Console.WriteLine("2 hr 30min");
                    break;
                case 3:
                    Console.WriteLine("2 hr 13 min");
                    break;
                case 4:
                    Console.WriteLine("2hr 31min");
                    break;
                default:
                    break;
            }
        
        }
        
    }
}
