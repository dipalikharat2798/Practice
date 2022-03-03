using Microsoft.VisualStudio.TestTools.UnitTesting;
using Test3.Models;
using System;
using System.Collections.Generic;
using System.Text;

namespace Test3.Models.Tests
{
    [TestClass()]
    public class AdditionTests
    {
        [TestMethod()]
        public void AddTest()
        {
            int a = 12;
            int b = 12;

            var add1 = new Addition(a,b);
            add1.Add(a,b);
        }
    }
}