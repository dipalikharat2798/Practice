using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Test3.Models
{
    public class Validate
    {
        public string username { get; set; }
        public string password { get; set; }
        public Validate(string username,string password) {

            this.username = username;
            this.password = password;
        }

        public bool validate(string username,string password) {

            if (username.Equals("Admin") && password.Equals("Pass")) {
                return true;
            }
            else{
                return false;
            }
        }
    }
}
