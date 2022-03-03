using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebAPICOREcodeapp.Models
{
    public class WeatherDB
    {
        [DataType(DataType.DateTime)]
        public string newcol { get; set; }
        public float TemperatureF { get; set; }
        public float TemperatureC { get; set; }
        public string summary { get; set; }
    }
}
