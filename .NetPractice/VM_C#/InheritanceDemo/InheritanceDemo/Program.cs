using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InheritanceDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            C obj = new C(10,20,30);
            //obj.Function1();
            obj.Function2();
            obj.Function3();
            Console.ReadLine();
        }
    }
}
