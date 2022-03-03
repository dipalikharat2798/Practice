using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace AuthorizationDemo.Controllers
{
    public class DefaultController : Controller
    {
        // GET: Default
        [AllowAnonymous]
        public ActionResult Index()
        {
            return View();
        }
        [Authorize]
        public ActionResult Page1()
        {
            return View();
        }
        [Authorize]
        public ActionResult Page2()
        {
            return View();
        }
        [Authorize]
        public ActionResult Page3()
        {
            return View();
        }
    }
}