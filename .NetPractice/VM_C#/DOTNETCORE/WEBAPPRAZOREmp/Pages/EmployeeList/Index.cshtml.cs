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
    public class IndexModel : PageModel
    {
        private readonly WEBAPPRAZOREmp.Models.ValueDB12 _context;

        public IndexModel(WEBAPPRAZOREmp.Models.ValueDB12 context)
        {
            _context = context;
        }

        public IList<Employee> Employee { get;set; }

        public async Task OnGetAsync()
        {
            Employee = await _context.Employees.ToListAsync();
        }
    }
}
