using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WEBAPPRAZOREmp.Models
{
    public class ValueDB12 : DbContext
    {
        public ValueDB12(DbContextOptions<ValueDB12> Options) : base(Options)
        {



        }
        public DbSet<Employee> Employees { get; set; }
    }
}
