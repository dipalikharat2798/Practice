using AreasMainFinal.Data;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AreasMainFinal.Areas.Admin.Controllers
{

    [Authorize(Roles = "Super Admin")]
    [Area("Admin")]
    public class ApplicationUserController : Controller
    {
        private readonly ApplicationDbContext _db;
        public ApplicationUserController(ApplicationDbContext db)
        {
            _db = db;

        }
        public IActionResult Index()
        {
            return View(_db.ApplicationUser.ToList());
        }
    }
}
