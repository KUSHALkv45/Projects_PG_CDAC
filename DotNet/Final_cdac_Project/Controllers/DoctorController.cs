using FinalProjectAtt3.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace FinalProjectAtt3.Controllers
{
    public class DoctorController : Controller
    {
        private readonly HospitalContext _context;
        private readonly IHttpContextAccessor _httpContextAccessor;

        public DoctorController(HospitalContext context, IHttpContextAccessor httpContextAccessor)
        {
            _context = context;
            _httpContextAccessor = httpContextAccessor;
        }
        public IActionResult Dashboard()
        {
            if (_httpContextAccessor.HttpContext.Session.GetInt32("DoctorId") == null)
                return RedirectToAction("Login");

            return View();
        }
        public IActionResult Login()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Login(string email, string password)
        {
            var user = _context.Doctors.FirstOrDefault(u => u.Email == email && u.Password == password);
            if (user != null && user.StatusOfApproval == true)
            {
                _httpContextAccessor.HttpContext.Session.SetInt32("DoctorId", user.DoctorId);
                // return RedirectToAction("Treatments");
                // return RedirectToAction("ViewSchedule") ;

                return RedirectToAction("Dashboard");
            }
            ViewBag.ErrorMessage = "Invalid username or password.";
            return View();
        }

        public IActionResult Signup()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Signup(Doctor doctor)
        {
            if (ModelState != null)
            {
                var existingDoctor = _context.Doctors.FirstOrDefault(d => d.Email == doctor.Email);
                if (existingDoctor == null)
                {
                    doctor.StatusOfApproval = false; // Pending approval
                    _context.Doctors.Add(doctor);
                    _context.SaveChanges();

                    return RedirectToAction("Login");
                }
                ViewBag.ErrorMessage = "Doctor already exists.";
            }
            return View(doctor);
        }

       

public IActionResult Treatments()
    {
        if (_httpContextAccessor.HttpContext.Session.GetInt32("DoctorId") == null)
            return RedirectToAction("Login");

        var doctorId = _httpContextAccessor.HttpContext.Session.GetInt32("DoctorId").Value;
        var treatments = _context.Treatments
                                 .Include(t => t.Patient) // Include Patient data
                                 .Include(t => t.Doctor)  // Include Doctor data
                                 
                                 .ToList();

        return View(treatments);
    }

    public IActionResult AddTreatment()
        {
            if (_httpContextAccessor.HttpContext.Session.GetInt32("DoctorId") == null)
            {  return RedirectToAction("Login"); }
                LoadDropdownData();
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult AddTreatment(Treatment treatment)
        {
            if (_httpContextAccessor.HttpContext.Session.GetInt32("DoctorId") == null)
            { return RedirectToAction("Login"); }
            // Validate Patient and Doctor
            treatment.Patient = _context.Patients.FirstOrDefault(p => p.PatientId == treatment.PatientId);
            treatment.Doctor = _context.Doctors.FirstOrDefault(d => d.DoctorId == treatment.DoctorId);

            if (treatment.Patient == null)
            {
                ModelState.AddModelError("PatientId", "Invalid Patient ID.");
            }

            if (treatment.Doctor == null)
            {
                ModelState.AddModelError("DoctorId", "Invalid Doctor ID.");
            }

            // Check if the model is valid before saving
            if (ModelState != null)
            {
                _context.Treatments.Add(treatment);
                _context.SaveChanges();
                return RedirectToAction("Treatments");
            }

            // Reload dropdown data if model is invalid
            LoadDropdownData();
            return View(treatment);
        }

        public IActionResult ViewSchedule()
        {
            if (_httpContextAccessor.HttpContext.Session.GetInt32("DoctorId") == null)
                return RedirectToAction("Login");

            var doctorId = _httpContextAccessor.HttpContext.Session.GetInt32("DoctorId").Value;
            var schedules = _context.DoctorSchedules.Where(ds => ds.DoctorId == doctorId).ToList();
            return View(schedules);
        }

       
        // GET: Treatments/EditTreatment/5
        public IActionResult EditTreatment(int? id)
        {
            if (_httpContextAccessor.HttpContext.Session.GetInt32("DoctorId") == null)
            { return RedirectToAction("Login"); }

            if (id == null)
            {
                return NotFound();
            }

            var treatment = _context.Treatments
                                    .Include(t => t.Patient)
                                    .Include(t => t.Doctor)
                                    .FirstOrDefault(t => t.TreatmentId == id);

            if (treatment == null)
            {
                return NotFound();
            }

            LoadDropdownData();
            return View(treatment);
        }

        // POST: Treatments/EditTreatment/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult EditTreatment(int id, Treatment treatment) /*[Bind("TreatmentId,PatientId,DoctorId,Diagnosis,Prescription,TreatmentDate")]*/
        {
            if (_httpContextAccessor.HttpContext.Session.GetInt32("DoctorId") == null)
            { return RedirectToAction("Login"); }
            if (id != treatment.TreatmentId)
            {
                return NotFound();
            }

            if (ModelState != null)
            {
                try
                {
                    // Ensure the related entities are attached to the context
                    treatment.Patient = _context.Patients.FirstOrDefault(p => p.PatientId == treatment.PatientId);
                    treatment.Doctor = _context.Doctors.FirstOrDefault(d => d.DoctorId == treatment.DoctorId);

                    _context.Update(treatment);
                    _context.SaveChanges();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!TreatmentExists(treatment.TreatmentId))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }
                return RedirectToAction(nameof(Treatments));
            }

            LoadDropdownData();
            return View(treatment);
        }


        // GET: Treatments/Delete/5
        public IActionResult DeleteTreatment(int id)
        {
            if (_httpContextAccessor.HttpContext.Session.GetInt32("DoctorId") == null)
            { return RedirectToAction("Login"); }
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

        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult DeleteTreatment(int id, Treatment treatment)
        {
            if (_httpContextAccessor.HttpContext.Session.GetInt32("DoctorId") == null)
            { return RedirectToAction("Login"); }
            var treatmentToDelete = _context.Treatments.Find(id);
            if (treatmentToDelete == null)
            {
                return NotFound();
            }

            _context.Treatments.Remove(treatmentToDelete);
            _context.SaveChanges();
            return RedirectToAction(nameof(Treatments));
        }
        public IActionResult Details(int id)
        {
            if (_httpContextAccessor.HttpContext.Session.GetInt32("DoctorId") == null)
            { return RedirectToAction("Login"); }
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

        private bool TreatmentExists(int id)
        {
            return _context.Treatments.Any(t => t.TreatmentId == id);
        }
        private void LoadDropdownData()
        {
            ViewBag.Patients = _context.Patients
                                       .Select(p => new { p.PatientId, Name = p.FirstName + " " + p.LastName })
                                       .ToList();

            ViewBag.Doctors = _context.Doctors
                                       .Select(p => new { p.DoctorId, Name = p.FirstName + " " + p.LastName })
                                       .ToList();
        }

        public IActionResult Logout()
        {
            _httpContextAccessor.HttpContext.Session.Clear();
            return RedirectToAction("Login");
        }
    }
}
