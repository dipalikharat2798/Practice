using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace ModelCal.Models
{
    public class Addition
    {
        
            [Display(Name = "Enter Num1")]
            public int Num1 { get; set; }

            [Display(Name = "Enter Num2")]
            public int Num2 { get; set; }
            public int Result { get; set; }
        
    }
}
