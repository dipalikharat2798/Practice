using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VirtalFun
{
    class Child : Parent
    {
        public void Function4()
        {
            Console.WriteLine("child Class Functional4");
        }
        public override sealed void Function2()
        {
            Console.WriteLine("child Class Functional2 override");
        }
        public new void Function3()
        {
            Console.WriteLine("new child Class Functional");
        }
    }
}
