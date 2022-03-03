using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;
namespace ModelValidation.Models
{
    public class Department
    {
        [Key]
        [Required]
        public int DeptNo { get; set; }

        [Required(ErrorMessage = "Department Name is Mandatory")]
        public string DeptName { get; set; }

        [Required]
        public string Loc { get; set; }
    }
}