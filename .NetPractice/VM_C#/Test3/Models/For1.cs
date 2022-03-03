using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Test3.Models
{
    public class For1
    {
        public int Num { get; set; }

        public int count { get; set; }

        public For1(int sum ) {

            this.Num = Num;
           
        }

        public int CalCount(int num) {
            int sum = 0;
            for (int a=1; a<num; a++) {

                sum = sum + 1;
            }
            return sum;
        }
    }
}
