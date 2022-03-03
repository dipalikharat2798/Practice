using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DayFive
{
    class Program
    {
        static void Main(string[] args)
        {
            Class1 obj = new Class1();
            /*  obj.GetValues();
              obj.DisplayValues();*/
            try
            {
                obj.GetValues();
                obj.DisplayValues();
            }
            catch (FormatException fe)
            {
                Console.WriteLine(fe.Message);
            }
            catch (IndexOutOfRangeException ie)
            {
                Console.WriteLine(ie.Message);
            }
            catch (Exception se)
            {
                Console.WriteLine(se.Message);
            }
            finally {
                Console.WriteLine("Finally Message executed");
            }
            Console.Read();
        }
        
    }
}
