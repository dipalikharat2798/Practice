#define DEBUG
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;
namespace AttributeDemo
{

    public class Myclass
    {
        [Conditional("DEBUG")]

        public static void Message(string msg)
        {
            Console.WriteLine(msg);
        }
    }
   
}
