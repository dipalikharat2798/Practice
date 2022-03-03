using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InheritanceDemo
{
    class C : B
    {
        int num3;
        public C(int num1, int num2,int num3): base(num1,num2)
        {
            this.num3 = num3;
            Console.WriteLine("Constructor of C");
        }
        public void Function3()
        {
            Console.WriteLine("Function3 Invoked {0}", num3);
        }
        ~C()
        {
            Console.WriteLine("Destructor of C");
        }
    }
}
