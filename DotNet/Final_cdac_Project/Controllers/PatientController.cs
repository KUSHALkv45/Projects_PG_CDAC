using FinalProjectAtt3.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System;
using System.Linq;

namespace FinalProjectAtt3.Controllers
{
    public class PatientController : Controller
    {
        private readonly HospitalContext _context;

        public PatientController(HospitalContext context)
        {
            _context = context;
        }

        public IActionResult Dashboard()
        {
            var patientId = HttpContext.Session.GetInt32("PatientId");
            if (patientId == null)
                return RedirectToAction("Login");

            return View();
        }



        public IActionResult Signup()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Signup(Patient patient)
        {
            if (ModelState != null)
            {
                _context.Patients.Add(patient);
                _context.SaveChanges();
                return RedirectToAction("Login");
            }
            return View(patient);
        }

        public IActionResult Login()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Login(string email, string password)
        {
            var patient = _context.Patients.FirstOrDefault(p => p.Email == email && p.Password == password);
            if (patient != null)
            {
                
                HttpContext.Session.SetInt32("PatientId", patient.PatientId);

                //return RedirectToAction("BookAppointment");
                // return RedirectToAction("AppointmentStatus");

                return RedirectToAction("Dashboard");

            }
            ViewBag.ErrorMessage = "Invalid email or password.";
            return View();
        }

        public IActionResult BookAppointment()
        {
            var patientId = HttpContext.Session.GetInt32("PatientId");
            if (patientId == null)
                return RedirectToAction("Login");
            ViewBag.Specializations = _context.Doctors
                                              .Select(d => d.Specialty)
                                              .Distinct()
                                              .ToList();
            return View();
        }

        [HttpPost]
        public IActionResult GetDoctors(string specialization)
        {
            var patientId = HttpContext.Session.GetInt32("PatientId");
            if (patientId == null)
                return RedirectToAction("Login");
            var doctors = _context.Doctors
                                  .Where(d => d.Specialty == specialization)
                                  .ToList();
            return Json(doctors);
        }

        [HttpPost]
        public IActionResult GetAvailableSlots(int doctorId, DateTime date)
        {
            var patientId = HttpContext.Session.GetInt32("PatientId");
            if (patientId == null)
                return RedirectToAction("Login");


            var schedule = _context.DoctorSchedules
                                   .FirstOrDefault(ds => ds.DoctorId == doctorId && ds.Date == date);

            if (schedule != null)
            {
                var availableSlots = new
                {
                    Slot1 = !schedule.Slot1,
                    Slot2 = !schedule.Slot2,
                    Slot3 = !schedule.Slot3,
                    Slot4 = !schedule.Slot4
                };

                return Json(availableSlots);
            }

            return Json(null);
        }

        [HttpPost]
        public IActionResult BookSlot(int doctorId, DateTime date, int slot)
        {
            var patientId = HttpContext.Session.GetInt32("PatientId");
            if (patientId == null)
                return RedirectToAction("Login");


            var doctorSchedule = _context.DoctorSchedules
                                          .FirstOrDefault(ds => ds.DoctorId == doctorId && ds.Date == date);

            if (doctorSchedule != null)
            {
                var slotBooked = slot switch
                {
                    1 => doctorSchedule.Slot1,
                    2 => doctorSchedule.Slot2,
                    3 => doctorSchedule.Slot3,
                    4 => doctorSchedule.Slot4,
                    _ => false
                };

                if (!slotBooked)
                {
                   

                    var appointment = new Appointment
                    {
                        PatientId = patientId ?? 0,
                        DoctorId = doctorId,
                        DoctorScheduleDoctorId = doctorId,
                        DoctorScheduleDate = date,
                        AppointmentDate = DateTime.Now,
                        SlotBooked = slot,
                        AppointmentStatus = 1 // Pending approval
                    };

                    _context.Appointments.Add(appointment);
                    _context.SaveChanges();
                    return RedirectToAction("AppointmentStatus");
                }
            }

            return View("Error");
        }

       
        public IActionResult AppointmentStatus()
        {
            var patientId = HttpContext.Session.GetInt32("PatientId");
            if (patientId == null)
                return RedirectToAction("Login");


            

            var appointments = _context.Appointments
                                       .Where(a => a.PatientId == patientId)
                                       .Include(a => a.Doctor)
                                       .Include(a => a.DoctorSchedule)
                                       .ToList();

            return View(appointments);
        }


        public IActionResult Treatments(int id)
        {
            var patientId = HttpContext.Session.GetInt32("PatientId");
            if (patientId == null)
                return RedirectToAction("Login");



            if (patientId == null)
            {
                return RedirectToAction("Login");
            }

            var treatments = _context.Treatments
                                     .Include(t => t.Patient) // Include Patient navigation property
                                     .Include(t => t.Doctor)  // Include Doctor navigation property
                                     .Where(t => t.PatientId == patientId)
                                     .ToList();

            return View(treatments);
        }

        public IActionResult Details(int id)
        {
            var patientId = HttpContext.Session.GetInt32("PatientId");
            if (patientId == null)
                return RedirectToAction("Login");


            var treatment = _context.Treatments
                                    .Include(t => t.Patient)
                                    .Include(t => t.Doctor)
                                    .FirstOrDefault(t => t.TreatmentId == id);

            if (treatment == null)
            {
                return NotFound();
            }

            return View(treatment);
        }

        public IActionResult Logout()
        {
           HttpContext.Session.Clear() ;
            return RedirectToAction("Login");
        }
    }
}
