using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Cors;
using System.Web.Http.Description;
using WebAPI.Models;

namespace WebAPI.Controllers
{
    [EnableCors("*", "*", "*")]
    public class AdminLoginController : ApiController
    {
        private ARSEntities1 db = new ARSEntities1();

        [HttpGet]
        public IHttpActionResult LoginAdmin(string Name, string Password)
        {
            Admin admin = db.Admins.Find(Name);
            Admin admin2 = db.Admins.Find(Password);
            if (admin == null && admin2 == null)
            {
                return NotFound();
            }
            
            return Ok(admin);
        }

    }
}
