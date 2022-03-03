using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DayFive
{
    class Class1
    {
        int[] arr;
        public Class1() {
            arr = new int[5];
        }

        public void GetValues() {
            try {
                for (int i=0; i< arr.Length;i++) {
                    Console.WriteLine("Enter value");
                    arr[i] = Convert.ToInt32(Console.ReadLine());
                }
            }
            catch (FormatException fe) {
                Console.WriteLine(fe.Message);
            }
        }
        public void DisplayValues()
        {
            try
            {
                for (int i = 0; i < 10; i++)
                {
                    Console.WriteLine("arr[10]={1}", i, arr[i]);
                   
                }
            }
            catch (IndexOutOfRangeException ie)
            {
                Console.WriteLine(ie.Message);
            }
        }
    }
}
