using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ThirdDay
{
    static public class MyStatic {

        static void Hello() {
            Console.WriteLine("Hello static");
        }
        static void Hello2()
        {
            Console.WriteLine("Hello2 static");
        }
        static void Main(string[] args)
        {
            MyStatic.Hello();
            MyStatic.Hello2();
            Console.Read();
        }
    }
    class Class4
    {
        public int Id { get; set; }
        public string Name { get; set; }
        static string university;
        static Class4() {
            university = "SGBAU";
            Console.WriteLine("Static Constructor executed");
        }
        public Class4() {
            Console.WriteLine("Non.Static Constructor executed");
        }
        public void GetDetails() {
            Console.WriteLine("Id:{0} ,Name:{1}, University:{2}",Id,Name,university);
        }
        static void Main(string[] args)
        {
            Class4 s1 = new Class4();
            Class4 s2 = new Class4();
            Class4 s3 = new Class4();
            s1.Id = 1;
            s1.Name = "a1";
            s2.Id = 2;
            s2.Name = "a2";
            s3.Id = 1;
            s3.Name = "a3";
            s1.GetDetails();
            s2.GetDetails();
            s3.GetDetails();
          
            Console.Read();

        }
    }
}
