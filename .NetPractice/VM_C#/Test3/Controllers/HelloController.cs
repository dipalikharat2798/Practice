using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Test3.Models;

namespace Test3.Controllers
{
    public class HelloController : Controller
    {
        public ActionResult AddWithHTMLHelperAndModel()
        {
            var model = new User();
            return View(model);
        }

    }
}
