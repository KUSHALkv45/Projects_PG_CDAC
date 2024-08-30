using System.ComponentModel.DataAnnotations;

namespace FinalProjectAtt3.Models
{
    public class DoctorSchedule
    {
        public int DoctorScheduleId { get; set; }

        public int DoctorId { get; set; }

        [Required]
        public DateTime Date { get; set; }

        [Required]
        public DayOfWeek DayOfWeek { get; set; }

        // Four time slots
        public bool Slot1 { get; set; } = false; // 10-11 AM
        public bool Slot2 { get; set; } = false; // 11-12 AM
        public bool Slot3 { get; set; } = false; // 2-3 PM
        public bool Slot4 { get; set; } = false; // 3-4 PM

        // Navigation property
        public Doctor Doctor { get; set; }
        public ICollection<Appointment> Appointments { get; set; }
    }
}
