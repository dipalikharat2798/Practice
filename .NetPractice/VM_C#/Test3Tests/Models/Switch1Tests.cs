using Microsoft.VisualStudio.TestTools.UnitTesting;
using Test3.Models;
using System;
using System.Collections.Generic;
using System.Text;

namespace Test3.Models.Tests
{
    [TestClass()]
    public class Switch1Tests
    {
        [TestMethod()]
        public void CalTest()
        {
            int a = 3;
            int num1 = 12;
            int num2 = 4;

            var val = new Switch1(a,num1,num2);
            val.Cal(a,num1,num2);
           
        }
    }
}