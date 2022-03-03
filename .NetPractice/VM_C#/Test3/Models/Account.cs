using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Test3.Models
{
    public class Account
    {
        public string AccNumber { get; set; }
        public string Name { get; set; }
        public double Balance { get; set; }


        public Account(string AccNumber, string Name, double Balance)
        {
            this.AccNumber = AccNumber;
            this.Name = Name;
            this.Balance = Balance;

        }
        public void Withdraw(double amount)
        {
            if (Balance >= amount)
            {
                Balance -= amount;
            }
            else
            {
                throw new ArgumentException(nameof(amount), "Withdrawal exceeds balance!");
            }
        }
       
    }
}
