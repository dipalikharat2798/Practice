using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using CalculatorUsingRazor.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace CalculatorUsingRazor.Pages
{
    public class CalculatorDModelModel : PageModel
    {
        [TempData]
        public int Result { get; set; }




        [BindProperty]
        public TwoNumbers Num { get; set; }



        public void OnGet()
        {
        }



        public IActionResult OnPostAddition()
        {
            var result = Num.NumberOne + Num.NUmberTwo;
            Result = result;
            return Page();
        }



        public IActionResult OnPostSubtraction()
        {
            var result = Num.NumberOne - Num.NUmberTwo;
            Result = result;
            return Page();
        }
        public IActionResult OnPostMultiplication()
        {
            var result = Num.NumberOne * Num.NUmberTwo;
            Result = result;
            return Page();
        }
        public IActionResult OnPostDivision()
        {
            var result = Num.NumberOne / Num.NUmberTwo;
            Result = result;
            return Page();
        }
    }
}

