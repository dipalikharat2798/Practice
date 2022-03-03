using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebMVCCAL.Models
{
    public class Numbers
    {

        [Required]
        public int Num1 { get; set; }
        [Required]
        public int Num2 { get; set; }
    }
}
