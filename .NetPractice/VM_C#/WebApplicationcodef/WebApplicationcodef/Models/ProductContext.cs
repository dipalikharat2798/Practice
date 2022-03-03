using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;
namespace WebApplicationcodef.Models
{
    public class ProductContext : DbContext
    {
        public ProductContext():base("Constr")
        {

       }
        public DbSet<Product> Products { get; set; }
    }
}