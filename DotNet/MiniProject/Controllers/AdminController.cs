using Microsoft.AspNetCore.Mvc;
using CompleteMiniProjectFinal.Models;
using System.Linq;
using Microsoft.AspNetCore.Http;


namespace CompleteMiniProjectFinal.Controllers
{
    public class AdminController : Controller
    {
        private readonly HospitalContext _context;
        private readonly IHttpContextAccessor _httpContextAccessor;

        public AdminController(HospitalContext context, IHttpContextAccessor httpContextAccessor)
        {
            _context = context;
            _httpContextAccessor = httpContextAccessor;
        }

        // GET: Admin/Login
        public IActionResult Login()
        {
            return View();
        }

        // POST: Admin/Login
        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult Login(Admin admin)
        {
            var adminInDb = _context.Admins.SingleOrDefault(a => a.Username == admin.Username && a.Password == admin.Password);
            if (adminInDb != null)
            {
                if(_httpContextAccessor.HttpContext.Session != null)
                _httpContextAccessor.HttpContext.Session.SetInt32("AdminId", adminInDb.AdminId);
                return RedirectToAction("AddDoctor", "Admin");
            }
            ModelState.AddModelError("", "Invalid login attempt.");
            return View(admin);
        }

        // GET: Admin/AddDoctor
        public IActionResult AddDoctor()
        {
            return View("~/Views/Admin/AddDoctor.cshtml");
        }


        // POST: Admin/AddDoctor
        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult AddDoctor(ListDoctors doctor)
        {
            if (ModelState.IsValid)
            {
                _context.ListDoctors.Add(doctor);
                _context.SaveChanges();
                return RedirectToAction("AddDoctor", "Admin");
            }
            return View(doctor);
        }
    }
}
