using FinalProjectAtt3.Models;
using Microsoft.AspNetCore.Mvc;

namespace FinalProjectAtt3.Controllers
{
    public class DoctorSchedulesController : Controller
    {
        private readonly HospitalContext _context;

        public DoctorSchedulesController(HospitalContext context)
        {
            _context = context;
        }

        public void GenerateSchedule(int doctorId)
        {
            for (int i = 1; i <= DateTime.DaysInMonth(DateTime.Now.Year, DateTime.Now.Month); i++)
            {
                var date = new DateTime(DateTime.Now.Year, DateTime.Now.Month, i);
                var schedule = new DoctorSchedule
                {
                    DoctorId = doctorId,
                    Date = date,
                    DayOfWeek = date.DayOfWeek ,
                    Slot1 = false,
                    Slot2 = false,
                    Slot3 = false,
                    Slot4 = false 
                };
                _context.DoctorSchedules.Add(schedule);
            }
            _context.SaveChanges();
        }

        public IActionResult ViewSchedule(int doctorId)
        {
            var schedules = _context.DoctorSchedules.Where(ds => ds.DoctorId == doctorId).ToList();
            return View(schedules);
        }
    }
}
