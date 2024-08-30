using System;
using System.ComponentModel.DataAnnotations;
using CompleteMiniProjectFinal.Models;

public class Treatment
{
    
    public int TreatmentId { get; set; }

    public int PatientId { get; set; }



    public int DoctorId { get; set; }


    [Required]
    [StringLength(50)]
    [RegularExpression(@"^[a-zA-Z ]+$", ErrorMessage = "can only contain letters")]
    public string Diagnosis { get; set; }

    [Required]
    [StringLength(50)]
    [RegularExpression(@"^[a-zA-Z ]+$", ErrorMessage = "can only contain letters")]
    public string Prescription { get; set; }

    [DataType(DataType.Date)]
    [Required]
    public DateTime TreatmentDate { get; set; }

    public Patient Patient { get; set; }
    public Doctor Doctor { get; set; }
}
