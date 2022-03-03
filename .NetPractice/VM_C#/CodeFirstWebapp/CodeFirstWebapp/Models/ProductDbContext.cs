using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.entity;
namespace CodeFirstWebapp.Models
{
    public class ProductDbContext : Db
    {
        public ProductDbContext() : base("Constr")
        { }
        public DbSet<Product> Products { get; set; }
    }
}