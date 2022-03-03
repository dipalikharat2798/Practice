using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FourthDay
{
    public struct OrderDetails { 
     public int OrderID { get; set; }
    public string Product { get; set; }
        public float  Price { get; set; }
        public int Units { get; set; }

        public void Function1() {
            Console.WriteLine("Function of structure");
        }

    }


    class Class1
    {
        OrderDetails ord = new OrderDetails();

        public void GetDetails() {
            Console.WriteLine("Enter orderid, products,price,units");
            ord.OrderID = Convert.ToInt32(Console.ReadLine());
            ord.Product = Console.ReadLine();
                ord.Price= Convert.ToSingle(Console.ReadLine());
            ord.Units= Convert.ToInt32(Console.ReadLine());
        }

        public void DisplayDetails() {
            Console.WriteLine(ord.OrderID);
            Console.WriteLine(ord.Product);
            Console.WriteLine(ord.Price);
            Console.WriteLine(ord.Units);

        }

        static void Main(string[] args)
        {
            Class1 obj = new Class1();
            obj.GetDetails();
            obj.DisplayDetails();
            Console.ReadLine();
        }
    }
}
