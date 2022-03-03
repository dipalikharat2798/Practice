using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AttributeDemo
{
    class Myclass2
    {
        [Obsolete("Don't use OldMethod, use NewMethod instead", true)]

        static void OldMethod()
        {
            Console.WriteLine("It is the old method");
        }
        static void NewMethod()
        {
            Console.WriteLine("It is the new method");
        }
        public static void Main()
        {
            //OldMethod();
            Console.Read();
        }
    }
}
