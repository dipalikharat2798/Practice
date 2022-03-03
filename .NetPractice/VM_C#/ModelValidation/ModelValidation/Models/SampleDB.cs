using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace ModelValidation.Models
{
    public class SampleDBDbContext : DbContext
    {
        public SampleDBDbContext() : base("Constr")
        {

        }
        public DbSet<Department> Departments { get; set; }
        public DbSet<Employee> Employees { get; set; }
    }
}