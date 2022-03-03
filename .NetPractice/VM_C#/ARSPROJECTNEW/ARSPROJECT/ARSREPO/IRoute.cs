using ARSDAL;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ARSREPO
{
    public interface IRoute
    {
        Route ValidateRoute(string from, string to);
    }
}
