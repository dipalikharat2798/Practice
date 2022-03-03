using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WEBAPPENTITY.Models
{
    public class Product
    {
        [Key]
        public int ProductId { get; set; }



        [Required]
        public string Name { get; set; }
        [Required]
        [Range(200, 1000, ErrorMessage = "Price range should be between 200-1000")]
        public float Price { get; set; }
    }
}
