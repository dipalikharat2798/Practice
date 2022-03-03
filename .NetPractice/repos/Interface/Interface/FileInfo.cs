using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Interface
{
    class FileInfo : IFile , IBinaryFile
    {
        void IFile.ReadFile()
        {
            Console.WriteLine("Reading Text File");
        }

        void IBinaryFile.OpenBinaryFile()
        {
            Console.WriteLine("Opening Binary File");
        }

        void IBinaryFile.ReadFile()
        {
            Console.WriteLine("Reading Binary File");
        }

        public void Search(string text)
        {
            Console.WriteLine("Searching in File");
        }

        void IFile.WriteFile(string text)
        {
            throw new NotImplementedException();
        }
    }
}
