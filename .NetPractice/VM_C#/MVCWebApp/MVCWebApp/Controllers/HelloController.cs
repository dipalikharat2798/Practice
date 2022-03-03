using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVCWebApp.Controllers
{
    public class HelloController : Controller
    {
        // GET: Hello
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult Index1()
        {
            ViewBag.Message = "Your application About description page.";
            return View();
        }
        public ActionResult Index2()
        {
            ViewBag.Message = "Your application Contact description page.";
            return View();
        }
    }
}