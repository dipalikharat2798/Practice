using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using search.Models;

namespace search.Controllers
{
    public class Flight_ScheduleController : Controller
    {
        private ARSEntities db = new ARSEntities();

        // GET: Flight_Schedule
        public ActionResult Index()
        {
            var flight_Schedule = db.Flight_Schedule.Include(f => f.AirCraft1).Include(f => f.AirFare);
            return View(flight_Schedule.ToList());
        }
        public ActionResult Page1()
        {
            var flight_Schedule = db.Flight_Schedule.Include(f => f.AirCraft1).Include(f => f.AirFare);
            return View(flight_Schedule.ToList());
        }

        // GET: Flight_Schedule/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Flight_Schedule flight_Schedule = db.Flight_Schedule.Find(id);
            if (flight_Schedule == null)
            {
                return HttpNotFound();
            }
            return View(flight_Schedule);
        }

        // GET: Flight_Schedule/Create
        public ActionResult Create()
        {
            ViewBag.AirCraft = new SelectList(db.AirCrafts, "AcID", "AcNumber");
            ViewBag.NetFare = new SelectList(db.AirFares, "AfID", "AfID");
            return View();
        }

        // POST: Flight_Schedule/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "FlID,FlightDate,Departure,Arrival,AirCraft,NetFare")] Flight_Schedule flight_Schedule)
        {
            if (ModelState.IsValid)
            {
                db.Flight_Schedule.Add(flight_Schedule);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.AirCraft = new SelectList(db.AirCrafts, "AcID", "AcNumber", flight_Schedule.AirCraft);
            ViewBag.NetFare = new SelectList(db.AirFares, "AfID", "AfID", flight_Schedule.NetFare);
            return View(flight_Schedule);
        }

        // GET: Flight_Schedule/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Flight_Schedule flight_Schedule = db.Flight_Schedule.Find(id);
            if (flight_Schedule == null)
            {
                return HttpNotFound();
            }
            ViewBag.AirCraft = new SelectList(db.AirCrafts, "AcID", "AcNumber", flight_Schedule.AirCraft);
            ViewBag.NetFare = new SelectList(db.AirFares, "AfID", "AfID", flight_Schedule.NetFare);
            return View(flight_Schedule);
        }

        // POST: Flight_Schedule/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "FlID,FlightDate,Departure,Arrival,AirCraft,NetFare")] Flight_Schedule flight_Schedule)
        {
            if (ModelState.IsValid)
            {
                db.Entry(flight_Schedule).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.AirCraft = new SelectList(db.AirCrafts, "AcID", "AcNumber", flight_Schedule.AirCraft);
            ViewBag.NetFare = new SelectList(db.AirFares, "AfID", "AfID", flight_Schedule.NetFare);
            return View(flight_Schedule);
        }

        // GET: Flight_Schedule/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Flight_Schedule flight_Schedule = db.Flight_Schedule.Find(id);
            if (flight_Schedule == null)
            {
                return HttpNotFound();
            }
            return View(flight_Schedule);
        }

        // POST: Flight_Schedule/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Flight_Schedule flight_Schedule = db.Flight_Schedule.Find(id);
            db.Flight_Schedule.Remove(flight_Schedule);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
