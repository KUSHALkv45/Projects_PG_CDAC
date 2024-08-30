using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace FinalProjectAtt3.Models
{
    public class Appointment
    {
        public int AppointmentId { get; set; }

        [Required]
        public int PatientId { get; set; }

        [Required]
        public DateTime AppointmentDate { get; set; }


        public int AppointmentStatus { get; set; }  // 1 - waiting for app , 2 - approved , 3-cancelled

        [Required]
        public int DoctorId { get; set; }

        // Composite foreign key to DoctorSchedule
        public int DoctorScheduleDoctorId { get; set; }

        public DateTime DoctorScheduleDate { get; set; }

        [Required]
        public int SlotBooked { get; set; } // 1 for Slot1, 2 for Slot2, 3 for Slot3, 4 for Slot4

        // Navigation properties
        [ForeignKey("DoctorScheduleDoctorId,DoctorScheduleDate")]
        public DoctorSchedule DoctorSchedule { get; set; }
        public Patient Patient { get; set; }
        public Doctor Doctor { get; set; }
    }
}
