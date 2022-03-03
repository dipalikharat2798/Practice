using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;
namespace ThirdDay
{
    class Class6
    {
        static void Main(string[] args) {
            ArrayList arr = new ArrayList() {"Dip", 56, true,'c' };
            for (int i=0; i<arr.Count;i++) {
                Console.WriteLine(arr[i]);
            }
            arr.Add("New Vm");
            foreach (var a in arr) {
                Console.WriteLine(a);
            }
            Console.Read();
        }
    }
}
