using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
namespace ConsoleApp3
{
    class Program
    {
        static void Main(string[] args)
        {

            String path = @"Pictures\MyTestFile1.txt";
            DirectoryInfo fl = new DirectoryInfo(path);
            fl.Create();
            {
                Console.WriteLine("Directory has been created");
            }
            Console.Read();

        }
    }
}
