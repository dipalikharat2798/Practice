using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using WebAPI.Models;

namespace WebAPI.Controllers
{
    public class PassengersController : ApiController
    {
        private ARSEntities1 db = new ARSEntities1();

        // GET: api/Passengers
        public IQueryable<Passenger> GetPassengers()
        {
            return db.Passengers;
        }

        // GET: api/Passengers/5
        [ResponseType(typeof(Passenger))]
        public IHttpActionResult GetPassenger(int id)
        {
            Passenger passenger = db.Passengers.Find(id);
            if (passenger == null)
            {
                return NotFound();
            }

            return Ok(passenger);
        }

        // PUT: api/Passengers/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutPassenger(int id, Passenger passenger)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != passenger.PsID)
            {
                return BadRequest();
            }

            db.Entry(passenger).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!PassengerExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/Passengers
        [ResponseType(typeof(Passenger))]
        public IHttpActionResult PostPassenger(Passenger passenger)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Passengers.Add(passenger);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = passenger.PsID }, passenger);
        }

        // DELETE: api/Passengers/5
        [ResponseType(typeof(Passenger))]
        public IHttpActionResult DeletePassenger(int id)
        {
            Passenger passenger = db.Passengers.Find(id);
            if (passenger == null)
            {
                return NotFound();
            }

            db.Passengers.Remove(passenger);
            db.SaveChanges();

            return Ok(passenger);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool PassengerExists(int id)
        {
            return db.Passengers.Count(e => e.PsID == id) > 0;
        }
    }
}