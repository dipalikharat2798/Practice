using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using WebApplicationRazor.Models;

namespace WebApplicationRazor.Pages
{
    public class EmployeeLoginModel : PageModel
    {
        [TempData]
        public string ErrorMessage { get; set; }
        [TempData]
        public string CancelMessage { get; set; }
        [BindProperty]
        public Elogin Login { get; set; }
        public void OnGet()
        {
        }


        public IActionResult OnPost()
        {
            if (Login.UserName.Equals("Admin") && Login.Password.Equals("Admin"))
            {
                return RedirectToPage("EmployeeHome");


            }
            else
            {
                ErrorMessage = "Invalid Credintials";
                return Page();
            }

        }
        public IActionResult OnPostCancel()
        {
            CancelMessage = "You Clicked on Cancel";
            return Page();
        }
    }
}
