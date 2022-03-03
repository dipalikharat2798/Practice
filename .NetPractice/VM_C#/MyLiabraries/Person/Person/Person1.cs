using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Person
{
    public class Person1
    {
        public bool ValidateUser(string username, string password)
        {

            if (username.Equals("Dipali") && password.Equals("Dkharat"))
            {
                return true;
            }
            else
            {
                return false;
            }

        }
    }
}