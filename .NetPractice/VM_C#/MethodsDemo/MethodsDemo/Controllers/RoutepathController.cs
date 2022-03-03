using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MethodsDemo.Controllers
{
    [RoutePrefix("My")]
    public class RoutepathController : Controller
    {
        // GET: Routepath

        [Route("bike/Honda")]
        public ActionResult Index()
        {
            return View();
        }
        [Route("bike/Honda1")]
        public ActionResult Index1()
        {
            return View();
        }
        [Route("bike/Pulser")]
        public ActionResult Index2()
        {
            return View();
        }

    }
}