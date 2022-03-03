using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace Codefirstmvc.Models
{
    public class DipaliDB :DbContext
    {
        public DipaliDB() : base("Constr") { 
        
        }

        public Dbset<Product> Products { get; set; }
    }
}