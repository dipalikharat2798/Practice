using CalculateMVC.Models;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CalculateMVC.Controllers
{
    public class HelloController : Controller
    {
        [HttpPost]
        public IActionResult Index(TwoNumbers model, string Add, string Substract, string Multiply, string Divide)
        {
            if (!String.IsNullOrEmpty(Add))
            {
                model.result = model.NumberOne + model.NUmberTwo;
            }
            if (!String.IsNullOrEmpty(Substract))
            {
                model.result = model.NumberOne - model.NUmberTwo;
            }
            if (!String.IsNullOrEmpty(Multiply))
            {
                model.result = model.NumberOne * model.NUmberTwo;
            }
            if (!String.IsNullOrEmpty(Divide))
            {
                model.result = model.NumberOne / model.NUmberTwo;
            }



            return View(model);
        }
    }
}
