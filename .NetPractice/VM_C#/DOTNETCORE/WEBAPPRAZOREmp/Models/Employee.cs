using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WEBAPPRAZOREmp.Models
{
    public class Employee
    {
        [Key]
        public int EmpId { get; set; }

        [Required]
        public string Name { get; set; }
        [Required]
        [Range(20, 60, ErrorMessage = "Age range should be between 20-60")]
        public float Age { get; set; }
    }
}
