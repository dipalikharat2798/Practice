using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Interface
{
    class Program
    {
        static void Main(string[] args)
        {
            /* IShape s;
             int Num;
             s = new Square();
             s.CalculateArea();
             Console.ReadLine();
            IFile file1 = new FileInfo();
            FileInfo file2 = new FileInfo();

            file1.ReadFile();
            file1.WriteFile("content");

            file2.ReadFile();
            file2.WriteFile("content");
            Console.ReadLine();*/
            IFile file1 = new FileInfo();
            IBinaryFile file2 = new FileInfo();
            FileInfo file3 = new FileInfo();

            file1.ReadFile();
            //file1.OpenBinaryFile(); //compile-time error 
            //file1.SearchFile("text to be searched"); //compile-time error 

            file2.OpenBinaryFile();
            file2.ReadFile();
            //file2.SearchFile("text to be searched"); //compile-time error 

            file3.Search("text to be searched");
            //file3.ReadFile(); //compile-time error 
            //file3.OpenBinaryFile(); //compile-time error 
            Console.ReadLine();
        }
    }
}
