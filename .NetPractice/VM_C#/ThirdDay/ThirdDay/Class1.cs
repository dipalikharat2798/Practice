using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ThirdDay
{
    class Class1
    {
        public void Add(int a, int b)
        {
            Console.WriteLine("{0}+{1}={2}", a, b, a + b);
        }
        public void Add(int a, string b)
        {
            Console.WriteLine("{0}+{1}={2}", a, b, a + b);
        }

        public static void Main(string[] args)
        {
            Class1 ob = new Class1();
            ob.Add(1, 2);
            ob.Add(1, "str");
        }
    }
}
