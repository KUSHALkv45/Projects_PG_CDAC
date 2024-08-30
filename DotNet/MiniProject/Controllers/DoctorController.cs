
using Microsoft.AspNetCore.Mvc;
using CompleteMiniProjectFinal.Models;
using System.Numerics;
using Microsoft.AspNetCore.Http;


namespace CompleteMiniProjectFinal.Controllers;
public class DoctorController : Controller
    {
        private readonly HospitalContext _context;

    private readonly IHttpContextAccessor _httpContextAccessor;

    public DoctorController(HospitalContext context , IHttpContextAccessor httpContextAccessor)
        {
            _context = context;
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
        var user = _context.Doctors.FirstOrDefault(u => u.Email == email && u.Password == password);

        if (user != null)
        {
            if (_httpContextAccessor.HttpContext != null)
                _httpContextAccessor.HttpContext.Session.SetInt32("DoctorId", user.DoctorId);

            return RedirectToAction("Treatments", "Treatments");
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
    [HttpPost]
    public IActionResult Signup(Doctor doctor)
    {
        if (ModelState.IsValid)
        {
            // Check if email already exists
            var existingDoctor = _context.ListDoctors.FirstOrDefault(d => d.mail == doctor.Email);
            if (existingDoctor != null)
            {
                //ModelState.AddModelError("Email", "A doctor with this email address already exists.");
                //return View(doctor);
                _context.Doctors.Add(doctor);
                _context.SaveChanges();
                return RedirectToAction("Login");
            }

           
        }
        return View(doctor);
    }




    //public IActionResult Treatments()
    //{
    //    var treatments = _context.Treatments.ToList(); // Fetch all treatments from database
    //    return View(treatments);
    //}



}

