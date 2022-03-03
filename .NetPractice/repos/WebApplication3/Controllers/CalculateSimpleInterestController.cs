using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Web;
using System.Web.Mvc;
using WebApplication3.Models;

namespace WebApplication3.Controllers
{
    public class CalculateSimpleInterestController : Controller
    {

       
        public ActionResult SimpleInterest()
        {
            SimpleInterestModel model = new SimpleInterestModel();
            return View(model);
        }
        [HttpPost]
        public ActionResult CalculateSimpleInterestResult(SimpleInterestModel model)
        {
            decimal simpleInteresrt = (model.Amount * model.Year * model.Rate) / 100;
            StringBuilder sbInterest = new StringBuilder();
            sbInterest.Append("<b>Amount :</b> " + model.Amount + "<br/>");
            sbInterest.Append("<b>Rate :</b> " + model.Rate + "<br/>");
            sbInterest.Append("<b>Time(year) :</b> " + model.Year + "<br/>");
            sbInterest.Append("<b>Interest :</b> " + simpleInteresrt);
            return Content(sbInterest.ToString());
        }
    }
}