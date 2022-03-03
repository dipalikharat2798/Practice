using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IndexerDemo
{
    class StringDataStore
    {
            private string[] strArr = new string[10]; // internal data storage

            public string this[int index]
            {
                get
                {
                    if (index < 0 || index >= strArr.Length)
                        throw new IndexOutOfRangeException("Index out of range");

                    return strArr[index];
                }

                set
                {
                    if (index < 0 || index >= strArr.Length)
                        throw new IndexOutOfRangeException("Index out of range");

                    strArr[index] = value;
                }
            }
        }
}

