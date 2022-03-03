using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;
namespace MVCWebApplication2.Models
{
    public class Elogin
    {
        [Display(Name ="Enter User Name")]
        public string Username { get; set; }

        [Display(Name = "Enter Password")]
       [ DataType(DataType.Password)]
        public string Password { get; set; }

    }
}