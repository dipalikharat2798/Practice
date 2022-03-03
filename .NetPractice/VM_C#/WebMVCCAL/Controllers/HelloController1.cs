using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebMVCCAL.Controllers
{
    public class HelloController1 : Controller
    {
        public IActionResult Page1()
        {
            return View();
        }
        [HttpPost]
        public ActionResult Calculat(string Num1, string Num2, string Cal)
        {
            int a = Convert.ToInt32(Num1);
            int b = Convert.ToInt32(Num2);
            int c = 0;
            switch (Cal)
            {
                case "Add":
                    c = a + b;
                    break;
                case "Sub":
                    c = a - b;
                    break;
                case "Mul":
                    c = a * b;
                    break;
                case "Div":
                    c = a / b;
                    break;
            }
            
            return View(c);
        }
    }
}
