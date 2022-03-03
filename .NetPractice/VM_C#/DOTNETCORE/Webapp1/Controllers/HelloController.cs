using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Webapp1.Models;

namespace Webapp1.Controllers
{
    public class HelloController : Controller
    {

        public IActionResult Index()
        {
            return View();
        }
        [HttpPost]
        public IActionResult Page1(Elogin model)
        {
            if (model.Username.Equals("Admin") && model.Passw0rd.Equals("Admin@123"))
                return RedirectToPage("Page2");
            else
            {
                ViewBag.Message = "Invalid credentials";
                return View(model);
            }
        }
        public IActionResult Page2()
        {
            return View();
        }
    }
}
