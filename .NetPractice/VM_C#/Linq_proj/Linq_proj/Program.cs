using System;
using System.Linq;

namespace Linq_proj
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = new int[10] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };



            string[] names = new string[6] { "Rupesh", "Amey", "Ananya", "Anjali", "Dipali", "Lakshmi" };



            //LINQ Query
            //    var result = from a in arr
            //select a;

           

            //LINQ Method
            var result = arr.Select(a => a);



            foreach (var a in result)
            {
                Console.WriteLine(a);
            }



            //LINQ Query
            /*  var result2 = from a in names
                           select a; */



            var result2 = names.Select(a => a);



            foreach (var a in result2)
            {
                Console.WriteLine(a);
            }



            Console.Read();
        }
    }
}
