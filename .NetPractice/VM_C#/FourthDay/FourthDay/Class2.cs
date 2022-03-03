using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FourthDay
{
    struct Coordinate {
        public int x;

        public int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void SetOrigin() {
            this.x = 0;
            this.y = 0;
        }
    }
    class Class2
    {
        static void Main(string[] args)
        {
            Coordinate point = new Coordinate();
            point.SetOrigin();
            Console.WriteLine(point.x);
            Console.WriteLine(point.y);

            Coordinate point2 = new Coordinate(10,20);
            Console.WriteLine(point2.x);
            Console.WriteLine(point2.y);
            Console.ReadLine();

        }
    }
}
