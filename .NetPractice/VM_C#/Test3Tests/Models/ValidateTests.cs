using Microsoft.VisualStudio.TestTools.UnitTesting;
using Test3.Models;
using System;
using System.Collections.Generic;
using System.Text;

namespace Test3.Models.Tests
{
    [TestClass()]
    public class ValidateTests
    {
        [TestMethod()]
        public void validateTest()
        {
            string username = "Admin";
            string password = "Pass";

            var val = new Validate(username,password);
            val.validate(username,password);
        }
    }
}