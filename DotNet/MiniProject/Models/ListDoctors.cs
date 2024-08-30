using System.ComponentModel.DataAnnotations;

namespace CompleteMiniProjectFinal.Models
{
    public class ListDoctors
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [EmailAddress]
        public string mail { get; set; }
    }
}
