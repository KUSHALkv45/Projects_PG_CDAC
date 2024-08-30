using Microsoft.AspNetCore.Mvc;
using CompleteMiniProjectFinal.Models;
using System.Linq;
using Microsoft.EntityFrameworkCore;
using Microsoft.AspNetCore.Http;

namespace CompleteMiniProjectFinal.Controllers
{
    public class PatientController : Controller
    {
        private readonly HospitalContext _context;
        private readonly IHttpContextAccessor _httpContextAccessor;

        public PatientController(HospitalContext context, IHttpContextAccessor httpContextAccessor)
        {
            _context = context;
            _httpContextAccessor = httpContextAccessor;
            _httpContextAccessor = httpContextAccessor;
        }

        public IActionResult Login()
        {
            return View();
        }

        public IActionResult Signup()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Login(string email, string password)
        {
            var patient = _context.Patients.FirstOrDefault(u => u.Email == email && u.Password == password);

            if (patient != null)
            {
                if(_httpContextAccessor.HttpContext != null)
                _httpContextAccessor.HttpContext.Session.SetInt32("PatientId", patient.PatientId);
                // Redirect to the PatientTreatments action with the patient's ID
                return RedirectToAction("PatientTreatments", new { id = patient.PatientId });
            }

            // Handle invalid login
            ViewBag.ErrorMessage = "Invalid username or password.";
            return View("Login");
        }

        public IActionResult Logout()
        {
            if (_httpContextAccessor.HttpContext != null)
                _httpContextAccessor.HttpContext.Session.Clear();
            return RedirectToAction("Login");
        }


        [HttpPost]
        public IActionResult Signup(Patient patient)
        {
            if (ModelState.IsValid)
            {
                _context.Patients.Add(patient);
                _context.SaveChanges();
                return RedirectToAction("Login");
            }
            return View(patient);
        }

        public IActionResult PatientTreatments(int id)
        {
            var treatments = _context.Treatments
    .Include(t => t.Patient) // Include Patient navigation property if needed
    .Include(t => t.Doctor)  // Include Doctor navigation property
    .Where(t => t.PatientId == id)
    .ToList();



            return View(treatments); // Ensure this matches the view filename 'PatientTreatments.cshtml'
        }

        public IActionResult Details(int id)
        {
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

    }
}
