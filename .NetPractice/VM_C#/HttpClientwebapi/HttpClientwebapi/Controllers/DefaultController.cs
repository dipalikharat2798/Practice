using HttpClientwebapi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Web;
using System.Web.Mvc;

namespace HttpClientwebapi.Controllers
{
    public class DefaultController : Controller
    {
        // GET: Default
        public ActionResult Index()
        {
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("https://localhost:44359/api/");
                //HTTP GET
                var responseTask = client.GetAsync("students");
                responseTask.Wait();



                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {



                    var readTask = result.Content.ReadAsAsync<Student[]>();
                    readTask.Wait();



                    var students = readTask.Result;
                    return View(students);

                }
            }

            return View();
        }
    }
}