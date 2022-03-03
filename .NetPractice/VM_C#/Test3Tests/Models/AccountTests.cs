using Microsoft.VisualStudio.TestTools.UnitTesting;
using Test3.Models;
using System;
using System.Collections.Generic;
using System.Text;

namespace Test3.Models.Tests
{
    [TestClass()]
    public class AccountTests
    {
        [TestMethod()]
        public void WithdrawTest()
        {
            ///AAA
            ///// arrange
            double currentBalance = 10.0;
            string acno = "123456789";
            string name = "samatha";
            double withdrawal = 1.0;
            double expected = 9.0;

            var account = new Account(acno, name, currentBalance);

            // act
            account.Withdraw(withdrawal);


            // assert
            Assert.AreEqual(expected, account.Balance);
            // Assert.Fail();
        }
        [TestMethod]
        public void Withdraw_AmountMoreThanBalance_Throws()
        {
            // arrange
            var account = new Account("123434", "John Doe", 10.0);



            // act and assert
            Assert.ThrowsException<System.ArgumentException>(() => account.Withdraw(20.0));
        }

      
    }
}