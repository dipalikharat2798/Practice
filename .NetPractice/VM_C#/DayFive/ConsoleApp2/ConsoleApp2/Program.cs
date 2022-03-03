using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp2
{
    class Program
    {
        static void Main(string[] args)
        {
            string path = @"C:\Users\dipalik\Music\VM_C#\DayFive\MyTestFile1.txt";
            FileInfo fi = new FileInfo(path);

            Console.WriteLine("File name is {0} ", fi.Name);
            Console.WriteLine("File creation time is {0} ", fi.CreationTime.ToLongTimeString());
            Console.WriteLine("File Lastaccesstime is {0} ", fi.LastAccessTime.ToLongDateString());
            Console.WriteLine("File length is {0} ", fi.Length.ToString() + " Bytes");
            Console.WriteLine("File extension is {0} ", fi.Extension);
            Console.WriteLine("File exist is: ", fi.Exists);
            Console.WriteLine("File LastWriteTime is {0} ", fi.LastWriteTime);
            Console.Read();

        }
    }
}
