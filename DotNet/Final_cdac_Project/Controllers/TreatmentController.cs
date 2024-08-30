using FinalProjectAtt3.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace FinalProjectAtt3.Controllers
{
    public class TreatmentsController : Controller
    {
        private readonly HospitalContext _context;

        public TreatmentsController(HospitalContext context)
        {
            _context = context;
        }

        public IActionResult AddTreatment()
        {
            LoadDropdownData();
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult AddTreatment(Treatment treatment)
        {
            treatment.Patient = _context.Patients.FirstOrDefault(p => p.PatientId == treatment.PatientId);
            treatment.Doctor = _context.Doctors.FirstOrDefault(d => d.DoctorId == treatment.DoctorId);

            if (treatment.Patient == null || treatment.Doctor == null)
            {
                ModelState.AddModelError("PatientId", "Invalid Patient ID.");
                ModelState.AddModelError("DoctorId", "Invalid Doctor ID.");
            }

            if (ModelState.IsValid)
            {
                _context.Treatments.Add(treatment);
                _context.SaveChanges();
                return RedirectToAction(nameof(Treatments));
            }

            LoadDropdownData();
            return View(treatment);
        }

        public IActionResult Treatments()
        {
            var treatments = _context.Treatments
                                     .Include(t => t.Patient)
                                     .Include(t => t.Doctor)
                                     .ToList();
            return View(treatments);
        }

        public IActionResult EditTreatment(int? id)
        {
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

        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult EditTreatment(int id, Treatment treatment)
        {
            if (id != treatment.TreatmentId)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
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

        public IActionResult DeleteTreatment(int id)
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

        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult DeleteTreatment(int id, Treatment treatment)
        {
            var treatmentToDelete = _context.Treatments.Find(id);
            if (treatmentToDelete == null)
            {
                return NotFound();
            }

            _context.Treatments.Remove(treatmentToDelete);
            _context.SaveChanges();
            return RedirectToAction(nameof(Treatments));
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
                                       .Select(d => new { d.DoctorId, Name = d.FirstName + " " + d.LastName })
                                       .ToList();
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
