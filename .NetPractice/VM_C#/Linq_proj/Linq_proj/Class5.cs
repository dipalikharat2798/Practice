using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Linq_proj
{
    class Class5
    {
        static void Main()
        {
            int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

            //var query1 = from n in arr
            //             where n < 5
            //             select n;

            var query1 = arr.Where(n => n < 5);

            Console.Write("List - 1: ");

            foreach (int item in query1)
            {
                Console.Write(" " + item);
            }

            var query2 = from n in arr
                         where n > 5
                         select n;
            Console.Write("\nList - 2: ");

            foreach (int item in query2)
            {
                Console.Write(" " + item);
            }


            Console.ReadLine();
        }

    }
}
