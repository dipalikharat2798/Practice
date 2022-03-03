using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WEBAPPENTITY.Models
{
    public class NewVMDB : DbContext
    {
        public NewVMDB(DbContextOptions<NewVMDB> Options) : base(Options)
        {



        }



        public DbSet<Product> Products { get; set; }
    }
}
