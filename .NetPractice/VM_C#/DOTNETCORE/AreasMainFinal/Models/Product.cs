﻿using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace AreasMainFinal.Models
{
    public class Product
    {

        [Key]
        public int ProductId { get; set; }
        public string Name { get; set; }
        public float Prize { get; set; }

    }
}
