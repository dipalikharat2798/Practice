using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebApplication2.Models;

namespace WebApplication2.Controllers
{
    public class HelloController : Controller
    {
        // GET: Hello
        public ActionResult Index()
        {
            Employee emp = new Employee() { Id = 1, Name = "Neha", Designation = "Trainee" };
            ViewData["Employee"] = emp;
            ViewBag.Employee1 = emp;
            TempData["Employee2"] = emp;
            Session["Employee3"] = emp;
            return View();
        }
        public ActionResult Page1()
        {
            Employee emp = new Employee() { Id = 2, Name = "Preety", Designation = "Trainee" };
            return View(emp);
        }

        public ActionResult Page3()
        {
            Customer cust = new Customer() { CustomerID = 1001, Address = "Customer Address", EmailID = "Customer@gmail.com" };

            Supplier supp = new Supplier() { SupplierID = 2001, Address = "Supplier Address", EmailID = "Supplier@gmail.com" };

            CustSuppWrapper obj = new CustSuppWrapper() { customer = cust, supplier = supp };

            return View(obj);
        }
    }
}