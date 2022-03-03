using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ClientForApi.Controllers
{
    public class DefaultController : Controller
    {
        // GET: Default
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult AddEmployee()
        {
            return View();
        }
        public ActionResult EmployeeById()
        {
            return View();
        }
        public ActionResult UpdateEmployee()
        {
            return View();
        }
        public ActionResult DeleteEmployee()
        {
            return View();
        }
    }
}