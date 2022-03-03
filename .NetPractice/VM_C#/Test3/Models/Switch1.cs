using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Test3.Models
{
    public class Switch1
    {
        public int a { get; set; }
        public int Num1 { get; set; }
        public int Num2 { get; set; }
        public Switch1(int a ,int Num1,int Num2) {
            this.a = a;
            this.Num1 = Num1;
            this.Num2 = Num2;
        }

        public int Cal(int a , int num1,int num2) {

            int b = a;
            int c = num1;
            int d = num2;
            switch (b) {

                case 1: return c + d;
                        break;
                case 2:
                    return c - d;
                    break;
                case 3:
                    return c * d;
                    break;
                case 4:
                    return c / d;
                    break;

                default: break;


            }
            return 0;
        }
    }
}
