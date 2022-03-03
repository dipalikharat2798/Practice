using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ThirdDay
{
    class Class2
    {
         public int Num { get; set; }
        public Class2 Add(Class2 obj1, Class2 obj2) {
            Class2 obj3 = new Class2();
            obj3.Num = obj1.Num + obj2.Num;
            return obj3;
        }

        public static Class2 operator +(Class2 obj1, Class2 obj2)
        {
            Class2 obj3 = new Class2();
            obj3.Num = obj1.Num + obj2.Num;
            return obj3;
        }
        public static  Class2 operator ++(Class2 obj1)
        {
            obj1.Num++ ;
            return obj1;
        }

        static void Main(string[] args)
        {
            Class2 obj1 = new Class2();
            obj1.Num = 10;
            Class2 obj2 = new Class2();
            obj2.Num = 10;
            Class2 obj3 = new Class2();
            // obj3.Num = obj1.Num + obj2.Num;
            //obj3.Num = obj1.Num++;
            obj1.Num++;
            Console.WriteLine("obj3:{0}", obj1.Num);
            Console.Read();
        }

    }
}
