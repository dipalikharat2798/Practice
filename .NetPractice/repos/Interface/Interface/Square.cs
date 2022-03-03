using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Interface
{
    class Square : IShape
    {
        float side;
        float area;

        void IShape.CalculateArea()
        {
            Console.WriteLine("Enter a side of a square");
            side = Convert.ToSingle(Console.ReadLine());
            area = side * side;
            Console.WriteLine("Area of aquare{0}", area);
        }
    }
}
