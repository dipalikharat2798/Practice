using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ActionFilters.Controllers
{
    public class DemoController : Controller
    {
        [HttpGet]
        [OutputCache(Duration = 2000)]
        public ActionResult Index()
        {
            return View();
        }



        [HandleError]
        public ActionResult Page1()
        {
            return View();
        }



        [HandleError(View = "MyOwnError")]
        public ActionResult Page2()
        {
            return View();
        }


        [ChildActionOnly]
        public ActionResult Page3()
        {
            return View();
        }
        [ChildActionOnly]
        public ActionResult Page4()
        {
            return View();
        }

        [ChildActionOnly]
        public ActionResult Page6()
        {
            return PartialView("PartialView");
        }

        public ActionResult Page5()
        {
            return View();
        }
    }
}