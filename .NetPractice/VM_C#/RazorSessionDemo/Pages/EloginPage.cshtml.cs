using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using RazorSessionDemo.Model;
namespace RazorSessionDemo.Pages
{
   
    public class EloginPageModel : PageModel
    {
        [BindProperty]
        public Elogin El { set; get; }
        public void OnGet()
        {
        }
        public IActionResult OnPost() {
            if (El.Username != null)
            {
                HttpContext.Session.SetString("Username", El.Username);
                return RedirectToAction("EmployeeHome");
            }
            else {
                return Page();
            }
        }
    }
}
