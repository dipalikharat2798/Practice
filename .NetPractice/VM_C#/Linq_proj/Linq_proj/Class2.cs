using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Linq_proj
{
    class Class2
    {
        static void Main(string[] args)
        {
            string[] names = new string[6] { "Rupesh", "Amey", "Ananya", "Anjali", "Dipali", "Lakshmi" };



            //LINQ Query
            /* var result2 = from a in names
                           where a.StartsWith("A") && a.Length > 5
                           select a; */



            /* var result2 = (from a in names
                         where a.StartsWith("A") && a.Length > 5
                         select a).FirstOrDefault(); */



            var result2 = names.Where(a => a.StartsWith("A") && a.Length > 5);



            foreach (var a in result2)
            {
                Console.WriteLine(a);
            }



           // var result3 = names.Where(a => a.StartsWith("A") && a.Length > 5).FirstOrDefault();




          //  Console.WriteLine(result3);
        }
    }
}
