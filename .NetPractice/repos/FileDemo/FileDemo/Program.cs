using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System;
namespace FileDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            string s;
            Console.WriteLine("Enter the filename");
            s = Console.ReadLine();

            FileStream fs = new FileStream("C:\\Users\\dipalik\\Music\\VM_C#\\Test.txt",
                FileMode.OpenOrCreate,FileAccess.ReadWrite,FileShare.None);
            /*StreamWriter sw = new StreamWriter(fs);
            long v = sw.BaseStream.Seek(0, SeekOrigin.End);
            sw.WriteLine(s);
            sw.Flush();*/
            StreamReader sr = new StreamReader(fs);
            sr.BaseStream.Seek(0, SeekOrigin.Begin);
            s = sr.ReadToEnd();
            Console.WriteLine("My name");
            Console.WriteLine(s);
            Console.ReadLine();
       }

    }
}
