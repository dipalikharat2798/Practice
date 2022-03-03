using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MovieTicketProject
{
    public class Ticket : Login
    {
        public void Display() {

            Console.WriteLine("Here is Information about your tickets");
            Console.WriteLine("Gold   : 3000Rs");
            Console.WriteLine("Silver : 2000Rs");
            Console.WriteLine("Longer : 1000Rs");
        }
    }
}
