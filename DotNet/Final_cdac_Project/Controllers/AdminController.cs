using FinalProjectAtt3.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace FinalProjectAtt3.Controllers
{
    public class AdminController : Controller
    {
        private readonly HospitalContext _context;
        private readonly HttpContextAccessor _httpContextAccessor;

        public AdminController(HospitalContext context)
        {
            _context = context;
            _httpContextAccessor = new HttpContextAccessor(); 
        }

        public IActionResult Dashboard()
        {
            if (_httpContextAccessor.HttpContext.Session.GetInt32("AdminId") == null)
            { return RedirectToAction("Login"); }
            return View();
        }

        public IActionResult Login()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Login(string username, string password)
        {
            var admin = _context.Admins.FirstOrDefault(a => a.Username == username && a.Password == password);
            if (admin != null)
            {
                _httpContextAccessor.HttpContext.Session.SetInt32("AdminId", admin.AdminId);
                // return RedirectToAction("ApproveDoctors");
                // return RedirectToAction("ApproveAppointments");

                return RedirectToAction("Dashboard");
            }
            ViewBag.ErrorMessage = "Invalid username or password.";
            return View();
        }

        public IActionResult ApproveDoctors()
        {
             if (_httpContextAccessor.HttpContext.Session.GetInt32("AdminId") == null)
            { return RedirectToAction("Login"); }
            var pendingDoctors = _context.Doctors.Where(d => d.StatusOfApproval == false).ToList();
            return View(pendingDoctors);
        }

        [HttpPost]
        public IActionResult ApproveDoctor(int doctorId)
        {
            if (_httpContextAccessor.HttpContext.Session.GetInt32("AdminId") == null)
            { return RedirectToAction("Login"); }
            var doctor = _context.Doctors.Find(doctorId);
            if (doctor != null)
            {
                doctor.StatusOfApproval = true; // Approved
                _context.Doctors.Update(doctor);
                _context.SaveChanges();

                // Generate schedule for the doctor
                var doctorScheduleController = new DoctorSchedulesController(_context);
                doctorScheduleController.GenerateSchedule(doctor.DoctorId);
            }
            return RedirectToAction("ApproveDoctors");
        }

        public IActionResult ApproveAppointments()
        {
            if (_httpContextAccessor.HttpContext.Session.GetInt32("AdminId") == null)
            { return RedirectToAction("Login"); }
            var pendingAppointments = _context.Appointments.Include(a => a.Patient)
                               .Include(a => a.Doctor).Where(a => a.AppointmentStatus == 1).ToList();
            return View(pendingAppointments);
        }

        public IActionResult ApproveAppointment(int appointmentId)
        {
            if (_httpContextAccessor.HttpContext.Session.GetInt32("AdminId") == null)
            { return RedirectToAction("Login"); }
            // Find the appointment by its ID
            var appointment = _context.Appointments.Find(appointmentId);

            if (appointment != null)
            {
                // Update the appointment status to Approved
                appointment.AppointmentStatus = 2; // 2 indicates 'Approved'

                // Find the corresponding doctor's schedule for the appointment's date
                var doctorSchedule = _context.DoctorSchedules
                    .FirstOrDefault(ds => ds.DoctorId == appointment.DoctorId && ds.Date == appointment.DoctorScheduleDate);

                if (doctorSchedule != null)
                {
                    // Mark the appropriate slot as unavailable based on the slot booked in the appointment
                    switch (appointment.SlotBooked)
                    {
                        case 1:
                            doctorSchedule.Slot1 = true; //  10-11 AM
                            break;
                        case 2:
                            doctorSchedule.Slot2 = true; //  11-12 AM
                            break;
                        case 3:
                            doctorSchedule.Slot3 = true; //  2-3 PM
                            break;
                        case 4:
                            doctorSchedule.Slot4 = true; //  3-4 PM
                            break;
                    }

                    // Update the doctor schedule in the database
                    _context.DoctorSchedules.Update(doctorSchedule);
                }

                // Save changes to both Appointments and DoctorSchedules tables
                _context.Appointments.Update(appointment);
                _context.SaveChanges();
            }

            
            return RedirectToAction("ApproveAppointments"); // Redirect back to the Approve Appointments page
        }

        public IActionResult Logout()
        {
            _httpContextAccessor.HttpContext.Session.Clear() ;
            return RedirectToAction("Login");
        }
    }
}
