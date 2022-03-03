using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebApplicationRazor.Models
{
    public class Elogin
    {
        [Display(Name ="Enter Your Name")]
        [Required]
        public string UserName { get; set; }
        [Required]
        [Display(Name = "Enter Your Password")]
        [DataType(DataType.Password)]
        public string Password { get; set; }
    }
}
