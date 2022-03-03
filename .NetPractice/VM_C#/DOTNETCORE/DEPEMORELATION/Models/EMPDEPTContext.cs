using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace DEPEMORELATION.Models
{
    public class EMPDEPTContext : DbContext
    {
        public EMPDEPTContext(DbContextOptions<EMPDEPTContext> Options) : base(Options)
        {



        }

        public DbSet<Department> Departments { get; set; }



        public DbSet<Employee> Employees { get; set; }
    }
}
