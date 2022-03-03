using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ARS.Controllers
{
    public class DefaultController : Controller
    {
        // GET: Default
        public ActionResult Index()
        {
            return View();
        }

        [HandleError]
        public ActionResult Index12()
        {
            return View();
           
        }
        [HandleError]
        public ActionResult Index13()
        {

            try {
                throw new Exception("Spmething wrong Happen"); 
            }
            catch
            {
                return View();
            }
        }
        public ActionResult Index3()
        {
            return View();

        }
    }
}