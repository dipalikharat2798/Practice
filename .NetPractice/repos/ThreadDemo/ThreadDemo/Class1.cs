using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;
namespace ThreadDemo
{
    class Class1
    {
        public static void Function1() {
            for (int i=0; i<10;i++) {
                Console.WriteLine("function1 : {0}",i);
            }
        }
        public static void Function2()
        {
            for (int i = 0; i < 10; i++)
            {
               // Thread.Sleep(1000);
                Console.WriteLine("function2 : {0}", i);
            }
        }
    }
}
