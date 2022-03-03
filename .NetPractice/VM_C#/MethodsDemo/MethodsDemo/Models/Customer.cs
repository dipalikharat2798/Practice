using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace MethodsDemo.Models
{
    public class Customer
    {
        public int CustomerID { get; set; }
        public string CustName { get; set; }
        public string Address { get; set; }
        public string Gender { get; set; }
        public string City { get; set; }
        public string State { get; set; }

        public bool SendNotifications { get; set; }
    }
}