using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DayFive
{
    class InSufficientBalanceException : Exception
    {
        public InSufficientBalanceException(string s):base(s)
    }
}
