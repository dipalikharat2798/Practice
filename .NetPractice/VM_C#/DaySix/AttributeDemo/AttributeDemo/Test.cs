using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AttributeDemo
{
 

         class Test
    {
        static void function1()
        {
            Myclass.Message("In Function 1.");
            function2();
        }
        static void function2()
        {
            Myclass.Message("In Function 2.");
        }
        public static void Main(string[] args)
        {
            Myclass.Message("In Main function.");
            function1();
            Console.ReadKey();
        }
    }
}

