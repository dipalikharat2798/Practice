using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassLibrary1
{
    public class Class1
    {
        public bool ValidateCredentails(string username, string password) {
            if (username == "Administrator" && password == "Password@123")
            {
                return true;
            }
            else {
                return false;
            }
        
        }

    }
}
