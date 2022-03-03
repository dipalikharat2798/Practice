using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace Webrazor.Pages
{
    public class EmployeeLoginModelModel : PageModel
    {
       
       [ViewData]
        public string ErrorMessage { get; set; }

        [BindProperty]
        public string Login { get; set; }
        public object Username { get;  set; }
        public object Password { get;  set; }

        public void OnGet()
        {
        }

        public IActionResult OnPost()
        {
            if (Username.Equals("abc") && Password.Equals("123"))
            {
                return RedirectToPage("EmployeeHome");
            }
            else
            {
                ErrorMessage = "Invalid";
                return Page();
            }
        }
    }
}
