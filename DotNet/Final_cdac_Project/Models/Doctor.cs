using System.ComponentModel.DataAnnotations;

namespace FinalProjectAtt3.Models
{
    public class Doctor
    {
        public int DoctorId { get; set; }

        [Required]
        [StringLength(50)]
        [RegularExpression(@"^[a-zA-Z_]+$", ErrorMessage = "First name can only contain letters and underscores.")]
        public string FirstName { get; set; }

        [Required]
        [StringLength(50)]
        [RegularExpression(@"^[a-zA-Z_]+$", ErrorMessage = "Last name can only contain letters and underscores.")]
        public string LastName { get; set; }

        [Required]
        [StringLength(100)]
        public string Specialty { get; set; }

        [Required]
        [EmailAddress]
        public string Email { get; set; }

        [Required]
        [DataType(DataType.Password)]
        [RegularExpression(@"^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$",
            ErrorMessage = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character.")]
        public string Password { get; set; }

        [Required]
        public bool StatusOfApproval { get; set; } // New column added to track approval status

        public ICollection<DoctorSchedule> DoctorSchedules { get; set; }
        public ICollection<Appointment> Appointments { get; set; }
    }
}
