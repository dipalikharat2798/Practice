using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
namespace InheritanceDemo
{
    class A
    {
        int num1;
        public A(int num1)
        {
            this.num1 = num1;
            Console.WriteLine("Constructor of A");
        }
        protected void Function1() {
            Console.WriteLine("Function1 Invoked {0}", num1);
        }
        ~A() {
            Console.WriteLine("Destructor of A");
        }
    }
}
