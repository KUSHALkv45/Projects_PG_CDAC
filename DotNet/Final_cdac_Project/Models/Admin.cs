﻿using System.ComponentModel.DataAnnotations;

namespace FinalProjectAtt3.Models
{
    public class Admin
    {
        public int AdminId { get; set; }

        [Required]
        [StringLength(50)]
        public string Username { get; set; }

        [Required]
        [DataType(DataType.Password)]
        public string Password { get; set; }
    }
}
