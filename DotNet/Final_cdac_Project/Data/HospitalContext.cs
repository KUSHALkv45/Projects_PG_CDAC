using FinalProjectAtt3.Models;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Reflection.Emit;

namespace FinalProjectAtt3.Models
{
    public class HospitalContext : DbContext
    {
        public HospitalContext(DbContextOptions<HospitalContext> options) : base(options) { }

        public DbSet<Admin> Admins { get; set; }
        public DbSet<Doctor> Doctors { get; set; }
        public DbSet<Patient> Patients { get; set; }
        public DbSet<Treatment> Treatments { get; set; }
        public DbSet<DoctorSchedule> DoctorSchedules { get; set; }
        public DbSet<Appointment> Appointments { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            // Configuring composite key for DoctorSchedule
            modelBuilder.Entity<DoctorSchedule>()
                .HasKey(ds => new { ds.DoctorId, ds.Date });
            // Configure relationship between Appointment and DoctorSchedule
            modelBuilder.Entity<Appointment>()
                .HasOne(a => a.DoctorSchedule)
                .WithMany(ds => ds.Appointments)
                .HasForeignKey(a => new { a.DoctorScheduleDoctorId, a.DoctorScheduleDate })
                .OnDelete(DeleteBehavior.Restrict); // Use Restrict to avoid cascade issues

            // Configure relationship between Appointment and Doctor
            modelBuilder.Entity<Appointment>()
                .HasOne(a => a.Doctor)
                .WithMany(d => d.Appointments)
                .HasForeignKey(a => a.DoctorId)
                .OnDelete(DeleteBehavior.Restrict); // Use Restrict to avoid cascade issues

            // Configure relationship between Appointment and Patient
            modelBuilder.Entity<Appointment>()
                .HasOne(a => a.Patient)
                .WithMany(p => p.Appointments)
                .HasForeignKey(a => a.PatientId)
                .OnDelete(DeleteBehavior.Cascade); // You can use Cascade here if needed

            // Configuring the status of approval column for Doctor
            modelBuilder.Entity<Doctor>()
                .Property(d => d.StatusOfApproval)
                .HasDefaultValue(false); // assuming you want to default it to false

            // Add additional model configurations as necessary
        }
    }
}
