using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using AreasfinalDemo.Utility;
using Microsoft.AspNetCore.Authorization;
using AreasfinalDemo.Models;
namespace AreasfinalDemo.Areas.Admin.Controllers
{
    [Authorize(Roles = SD.SuperAdminEndUser)]
    [Area("Admin")]
    public class ApplicationUserController : Controller
    {
        private readonly ApplicationUserController _db;
        public ApplicationUserController(ApplicationUserController db) {
            _db = db;
        
        }

        public IActionResult Index() {
            return View();
        }
    }

}



