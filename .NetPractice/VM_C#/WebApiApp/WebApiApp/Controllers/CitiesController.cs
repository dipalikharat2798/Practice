using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace WebApiApp.Controllers
{
    public class CitiesController : ApiController
    {
        List<string> cities = InitCities();
        public static List<string> InitCities() {

            var ct = new List<string>();
            ct.Add("Hybs");
            ct.Add("Pune");
            ct.Add("delhi");
            ct.Add("Kolkatta");
            return ct;
        }
        // GET: api/Cities
        public IEnumerable<string> Get()
        {
            return cities;
        }

        // GET: api/Cities/5
        public string Get(int id)
        {
            return cities[id];
        }

        // POST: api/Cities
        public void Post([FromBody]string value)
        {
            cities.Add(value);
        }

        // PUT: api/Cities/5
        public void Put(int id, [FromBody]string value)
        {
            cities[id] = value;
        }

        // DELETE: api/Cities/5
        public void Delete(int id)
        {
            cities.RemoveAt(id);
        }
    }
}
