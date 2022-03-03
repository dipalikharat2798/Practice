using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VirtalFun
{
    class Parent
    {
        public void Function1() {
            Console.WriteLine("Parent Class Functional1");
        }
        public virtual void Function2()
        {
            Console.WriteLine("Parent Class Functional2");
        }
        public void Function3()
        {
            Console.WriteLine("Parent Class Functiona3");
        }

    }
}
