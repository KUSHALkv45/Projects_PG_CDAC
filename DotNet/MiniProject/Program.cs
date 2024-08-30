using Microsoft.EntityFrameworkCore;

namespace MedicalRecordsManagement
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container.
            builder.Services.AddControllersWithViews();
            builder.Services.AddDbContext<HospitalContext>(options =>
                options.UseSqlServer(builder.Configuration.GetConnectionString("HospitalContext")));

            // adding session here

            builder.Services.AddSession(options =>
            {
                // Set session timeout
                options.IdleTimeout = TimeSpan.FromMinutes(1); // Adjust as needed
                options.Cookie.HttpOnly = true;
                options.Cookie.IsEssential = true;
            });

            // Add HttpContextAccessor for accessing session in controllers
            builder.Services.AddHttpContextAccessor();


            var app = builder.Build();

            // Configure the HTTP request pipeline.
            if (!app.Environment.IsDevelopment())
            {
                app.UseExceptionHandler("/Home/Error");
                app.UseHsts();
            }

            app.UseHttpsRedirection();
            app.UseStaticFiles();

            app.UseRouting();

            app.UseSession();


            app.UseAuthorization();

            // Add the default route mapping
            app.MapControllerRoute(
                name: "default",
                pattern: "{controller=Home}/{action=Index}/{id?}");

            app.Run();
        }
    }
}
