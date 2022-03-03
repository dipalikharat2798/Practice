using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using MywebApi.Model;

namespace MywebApi.Controllers
{
    public class StudentdsController : Controller
    {
        private readonly VMDB2Context _context;

        public StudentdsController(VMDB2Context context)
        {
            _context = context;
        }

        // GET: Studentds
        public async Task<IActionResult> Index()
        {
            return View(await _context.Studentd.ToListAsync());
        }

        // GET: Studentds/Details/5
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var studentd = await _context.Studentd
                .FirstOrDefaultAsync(m => m.Id == id);
            if (studentd == null)
            {
                return NotFound();
            }

            return View(studentd);
        }

        // GET: Studentds/Create
        public IActionResult Create()
        {
            return View();
        }

        // POST: Studentds/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Id,Name,Marks")] Studentd studentd)
        {
            if (ModelState.IsValid)
            {
                _context.Add(studentd);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            return View(studentd);
        }

        // GET: Studentds/Edit/5
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var studentd = await _context.Studentd.FindAsync(id);
            if (studentd == null)
            {
                return NotFound();
            }
            return View(studentd);
        }

        // POST: Studentds/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("Id,Name,Marks")] Studentd studentd)
        {
            if (id != studentd.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(studentd);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!StudentdExists(studentd.Id))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }
                return RedirectToAction(nameof(Index));
            }
            return View(studentd);
        }

        // GET: Studentds/Delete/5
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var studentd = await _context.Studentd
                .FirstOrDefaultAsync(m => m.Id == id);
            if (studentd == null)
            {
                return NotFound();
            }

            return View(studentd);
        }

        // POST: Studentds/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            var studentd = await _context.Studentd.FindAsync(id);
            _context.Studentd.Remove(studentd);
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool StudentdExists(int id)
        {
            return _context.Studentd.Any(e => e.Id == id);
        }
    }
}
