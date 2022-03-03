using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DeligateEx
{
    class Program
    {
        public delegate void addnum(int a, int b);
        public delegate void subnum(int a, int b);

        // method "sum" 
       

        // method "subtract" 
       public void subtract(int a, int b)
        {
            Console.WriteLine("(100 - 60) = {0}", a - b);
        }
        
        // Main Method 

        public static void Main(String[] args)
        {

            
            Program obj = new Program();
            addnum del_obj1 = delegate (int a, int b)
           {
                Console.WriteLine("(100 + 40) = {0}", a + b);
            };
            subnum del_obj2 = new subnum(obj.subtract);

             
            del_obj1(100, 40);
            del_obj2(100, 60);

        
            Console.Read();
        }
    }
} 