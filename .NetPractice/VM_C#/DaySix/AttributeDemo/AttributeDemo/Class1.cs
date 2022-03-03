using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.InteropServices;
using System.Diagnostics;

namespace AttributeDemo
{
    class Class1
    {
        [DllImport("kernel32.dll")]
        public static extern bool Beep(uint frequency, uint duration);
        static void Main(string[] args)
        {
            Beep(1200000,3333);
            Console.Read();
        }
    }
}
