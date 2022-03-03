using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WithoutDB1
{
    class VMSchoolDB : DbContext
    {
        public VMSchoolDB() : base("Costr")
        {



        }
        public DbSet<Student> Students { get; set; }
        public DbSet<Grade> Grades { get; set; }
    }
    
}
