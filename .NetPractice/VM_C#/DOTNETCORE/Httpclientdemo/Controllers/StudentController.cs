using Httpclientdemo.Models;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;

namespace Httpclientdemo.Controllers
{
    public class StudentController : Controller
    {

        public IActionResult Index()
        {
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("https://localhost:44343/api/");
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



                return View();
            }
        }



        [HttpGet]
        public IActionResult Create()
        {
            return View();
        }



        [HttpPost]
        public IActionResult Create(Student model)
        {
            var client = new HttpClient { BaseAddress = new Uri("https://localhost:44343/api/") };
            string stringData = JsonConvert.SerializeObject(model);
            var contentData = new StringContent(stringData, System.Text.Encoding.UTF8, "application/json");



            HttpResponseMessage response = client.PostAsync
        ("students", contentData).Result;
            ViewBag.Message = response.Content.ReadAsStringAsync().Result;
            return RedirectToAction("Index");




        }



        [HttpGet]
        public IActionResult Edit(int id)
        {
            var client = new HttpClient { BaseAddress = new Uri("https://localhost:44343/api/") };



            HttpResponseMessage response = client.GetAsync("students/" + id).Result;
            string stringData = response.Content.
        ReadAsStringAsync().Result;
            Student data = JsonConvert.
        DeserializeObject<Student>(stringData);
            return View(data);
        }
        public IActionResult Edit(Student model)
        {
            var client = new HttpClient { BaseAddress = new Uri("https://localhost:44343/api/") };



            string stringData = JsonConvert.SerializeObject(model);
            var contentData = new StringContent(stringData,
        System.Text.Encoding.UTF8, "application/json");
            HttpResponseMessage response = client.PutAsync
        ("students/" + model.Id,
        contentData).Result;
            ViewBag.Message = response.Content.
        ReadAsStringAsync().Result;
            return RedirectToAction("Index");

        }




        public IActionResult Details(int id)
        {
            var client = new HttpClient { BaseAddress = new Uri("https://localhost:44343/api/") };



            HttpResponseMessage response = client.GetAsync("students/" + id).Result;
            string stringData = response.Content.
        ReadAsStringAsync().Result;
            Student data = JsonConvert.
        DeserializeObject<Student>(stringData);
            return View(data);

        }



        [HttpGet]
        public IActionResult Delete(int id)
        {
            var client = new HttpClient { BaseAddress = new Uri("https://localhost:44343/api/") };



            HttpResponseMessage response = client.GetAsync("students/" + id).Result;
            string stringData = response.Content.
        ReadAsStringAsync().Result;
            Student data = JsonConvert.
        DeserializeObject<Student>(stringData);
            return View(data);
        }





        [HttpPost]
        public IActionResult Delete(Student model)
        {
            var client = new HttpClient { BaseAddress = new Uri("https://localhost:44343/api/") };



            HttpResponseMessage response =
   client.DeleteAsync("students/"
   + model.Id).Result;
            TempData["Message"] =
        response.Content.ReadAsStringAsync().Result;
            return RedirectToAction("Index");

        }


    }
}
