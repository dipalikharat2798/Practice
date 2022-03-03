using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace DEPEMORELATION.Models
{
    public class Employee
    {
        [Key]
        [Required]
        public int EmployeeID { get; set; }



        [Required(ErrorMessage = "Please enter employee name.")]
        [StringLength(40)]
        public string EmpName { get; set; }



        [DataType(DataType.Password)]
        [Required]
        public string Password { get; set; }



        [DataType(DataType.Password)]
        [Required]
        [Compare("Password")]
        public string ConfirmPassword { get; set; }



        [Display(Name = "Address for communication")]
        [DataType(DataType.MultilineText)]
        public string Address { get; set; }



        [Required]
        public decimal Salary { get; set; }



        public string Phone { get; set; }



        [Required]
        [RegularExpression(@"(\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,6})", ErrorMessage = "Invalid E-Mail")]
        public string Email { get; set; }



        [Display(Name = "Date of Joining")]
        [DataType(DataType.Date)]
        public DateTime DateOfJoining { get; set; }



        [Required]
        public string Gender { get; set; }



        [Required]
        public string State { get; set; }



        [Required]
        public int DeptNo { get; set; }



        public string Hobbies { get; set; }



        [Required]
        [Range(18, 70, ErrorMessage = "Age should be in between 18 and 70.")]
        public int Age { get; set; }



        public bool AcceptLicenseAgreement { get; set; }



        [ForeignKey("DeptNo")]
        public virtual Department Department { get; set; }



    }
}
