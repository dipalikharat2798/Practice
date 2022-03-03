using ARSDAL;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ARSREPO
{
    public class RouteRepo : IRoute
    {
        
            ARSEntities db = new ARSEntities();
            public Route ValidateRoute(string from, string to)
            {
                Route l = db.Routes.Where(a => a.Airport.Equals(from) && a.Destination.Equals(to)).FirstOrDefault();
                return l;
            }
    }
}
