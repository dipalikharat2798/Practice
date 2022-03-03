using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InheritanceDemo
{
    class Employee
    {
        int EmpId;
        int EmpAge;
        float curPay;

        public Employee(int id, int age, int curpay) {
            this.EmpId = id;
            this.EmpAge = age;
            this.curPay = curpay;
        }
    }


}
