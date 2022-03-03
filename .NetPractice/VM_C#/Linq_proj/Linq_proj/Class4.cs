using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Linq_proj
{
    class Class4
    {
        static void Main(string[] args)
        {
            int[] arr = { 11, 10, 20, 21, 19, 18, 14, 15 };

            //even is called as range, used to range(iterate) over a list of items
            // arr is the data source called as Sequence

            var evens = from e in arr
                        where e % 2 == 0
                        select e;

            Console.Write("Evens: ");
            foreach (int n in evens)
            {
                Console.Write(" " + n);
            }

            Console.ReadLine();
        }

    }
}
