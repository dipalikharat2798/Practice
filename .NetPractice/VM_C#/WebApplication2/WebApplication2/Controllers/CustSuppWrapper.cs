using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebApplication2.Controllers
{
    public class CustSuppWrapper
    {
        public Customer customer { get; set; }
        public Supplier supplier { get; set; }
    }
}