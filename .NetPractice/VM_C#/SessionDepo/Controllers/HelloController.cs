using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using SessionDepo.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SessionDepo.Controllers
{
    public class HelloController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Index(EmployeeLogin model)
        {
            if (model.Username != null) {
                HttpContext.Session.SetString("Username",model.Username);
                return RedirectToAction("EmployeeHome");
            }
            return View(model);
        }
        public IActionResult EmployeeHome()
        {
            return View();
        }
        public IActionResult LeavePage()
        {
            return View();
        }
    }
}
