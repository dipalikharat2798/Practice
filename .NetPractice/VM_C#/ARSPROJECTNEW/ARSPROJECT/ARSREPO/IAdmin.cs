using ARSDAL;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ARSREPO
{
  public  interface IAdmin
    {
         Admin ValidateAdmin(string Name, string Password);
        int AddLogin(Admin obj);
        Admin ValidateAdmin(string name, object password);
    }
}
