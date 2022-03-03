using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using WEBAPPRAZOREmp.Models;

namespace WEBAPPRAZOREmp.Pages.EmployeeList
{
    public class DetailsModel : PageModel
    {
        private readonly WEBAPPRAZOREmp.Models.ValueDB12 _context;

        public DetailsModel(WEBAPPRAZOREmp.Models.ValueDB12 context)
        {
            _context = context;
        }

        public Employee Employee { get; set; }

        public async Task<IActionResult> OnGetAsync(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            Employee = await _context.Employees.FirstOrDefaultAsync(m => m.EmpId == id);

            if (Employee == null)
            {
                return NotFound();
            }
            return Page();
        }
    }
}
