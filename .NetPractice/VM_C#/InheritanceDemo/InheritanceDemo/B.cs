using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InheritanceDemo
{
    class B : A
    {
        int num2;
        public B(int num1, int num2): base(num1)
        {
            this.num2 = num2;
            base.Function1();
            Console.WriteLine("Constructor of B");
        }
        public void Function2()
        {
            Console.WriteLine("Function2 Invoked {0}", num2);
        }
        ~B()
        {
            Console.WriteLine("Destructor of B");
        }
    }
}
