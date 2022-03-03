using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace RelationShipDemo.Models
{
    public class Department
    {
        [Key]
        public int DeptNo { get; set; }



        [Required]
        [StringLength(40)]
        public string DeptName { get; set; }



        [Required]
        [StringLength(40)]
        public string Location { get; set; }
    }
}
