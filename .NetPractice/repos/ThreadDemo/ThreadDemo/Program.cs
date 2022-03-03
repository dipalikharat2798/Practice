using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;
namespace ThreadDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            Thread.CurrentThread.Name = "Main Thread";
            Console.WriteLine(Thread.CurrentThread.Name);
            Thread t1 = new Thread(Class1.Function1);
            ThreadStart ts = new ThreadStart(Class1.Function2);
            Thread t2 = new Thread(ts);
            t2.Priority = ThreadPriority.Highest;
            t1.Start();
            t2.Start();
            Console.ReadLine();

        }
    }
}
