﻿using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebApplication6.Models
{
   
        public class EmployeeDbContext : DbContext
        {
            public EmployeeDbContext(DbContextOptions options) : base(options)
            {
            }

            DbSet<Employee> Employees { get; set; }
        }
}