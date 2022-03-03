using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Test3.Models
{
    public class Addition
    {
        public int a { get; set; }
        public int b { get; set; }


        public Addition(int a, int b)
        {
            this.a = a;
            this.b = b;
        }

        public int Add(int a, int b)
        {
            var c = a + b;
            return c;
        }
    }
}
