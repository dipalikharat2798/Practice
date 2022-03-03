using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace viewbagwebapp.Controllers
{
    public class HelloController : Controller
    {
        // GET: Hello
       
       public ActionResult Index()
        {
            //To Send data from controller to view
            // we viewbag viewdata tempdata session

            int x = 100;

            ViewData["x"] = x;
            ViewBag.x = x;

            ViewData["Message1"] = "Value of ViewData"; //scope is single request
            TempData["Message2"] = "Value of TempData"; //scope is subsequent (two request)
            ViewBag.Message3 = "Value of ViewBag"; //scope is single request
            Session["Message4"] = "Value of Session"; //available throughout the session
                                                      //session time when you login till you logout

            return View();
        }


        public ActionResult Page1()
        {
            ViewData["Message1"] = "Value of ViewData";
            TempData["Message2"] = "Value of TempData";
            ViewBag.Message3 = "Value of ViewBag";
            Session["Message4"] = "Value of Session";


            return RedirectToAction("Page2");
        }

        public ActionResult Page2()
        {
            return View();
        }
    }
}
