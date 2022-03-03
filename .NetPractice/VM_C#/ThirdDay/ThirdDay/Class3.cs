using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ThirdDay
{
    class Class3
    {
        public int Num { get; set; }
        
        public static bool operator >(Class3 obj1, Class3 obj2)
        {
            if (obj1.Num > obj2.Num)
            {
                return true;
            }
            else {
                return false;
            }
        }
        public static bool operator <(Class3 obj1, Class3 obj2)
        {
            if (obj1.Num < obj2.Num)
            {
                return true;
            }
            else
            {
                return false;
            }
        }


        static void Main(string[] args)
        {
            Class3 obj1 = new Class3();
            obj1.Num = 10;
            Class3 obj2 = new Class3();
            obj2.Num = 10;

            if (obj1.Num > obj2.Num)
            {
                Console.WriteLine("obj1 is gratest");
            }
            else
            {
                Console.WriteLine("obj2 is gratest");
            }
            Console.Read();
        }
    }
}
