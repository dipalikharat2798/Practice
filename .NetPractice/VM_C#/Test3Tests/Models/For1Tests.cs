using Microsoft.VisualStudio.TestTools.UnitTesting;
using Test3.Models;
using System;
using System.Collections.Generic;
using System.Text;

namespace Test3.Models.Tests
{
    [TestClass()]
    public class For1Tests
    {
        [TestMethod()]
        public void CalCountTest()
        {
            int a = 10;
            var val = new For1(a);
            val.CalCount(a);
        }
    }
}