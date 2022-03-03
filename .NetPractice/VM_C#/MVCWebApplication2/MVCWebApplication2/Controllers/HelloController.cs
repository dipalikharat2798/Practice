using MVCWebApplication2.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVCWebApplication2.Controllers
{
    public class HelloController : Controller
    {
        // GET: Hello
        public ActionResult Index()
        {
            ViewBag.Message = "Your application description page.";
            return View();
        }
        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";
            return View();
        }
        public ActionResult Contact()
        {
            ViewBag.Message = "Your application description page.";
            return View();
        }

        public ActionResult Page4()
        {

            return View();
        }
        [HttpPost]
        public ActionResult Page4(Elogin model)
        {
            if (model.Username.Equals("Administrator") && model.Password.Equals("Pass123"))
                return RedirectToAction("Page5");
            else
            {
                ViewBag.Message = "Invalid username and Password";
                return View();

            }
        }
        public ActionResult Page5()
        {

            return View();
        }

    }
}