using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Interface
{
    class Circle : IShape
    {
        float pi;
        float radius;
        float area;
        public Circle() { 
        
        }
        void IShape.CalculateArea()
        {
            throw new NotImplementedException();
        }
    }
}
