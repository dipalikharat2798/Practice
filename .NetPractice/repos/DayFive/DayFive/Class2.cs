using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DayFive
{
    class Class2
    {
        float ACCBalance;
        float wd;

        public Class2() {
            ACCBalance = 200000f;
        }

        public void WithDraw() {
            Console.WriteLine("Enter amount to withdraw");
            wd = Convert.ToSingle(Console.ReadLine());

            try {
                if (wd ACCBalance){
                    throw new InsufficientExecutionStackException("Insufficient Balance");
                }
                else if (ACCBalance = ACCBalance - wd) {
                    throw new InsufficientExecutionStackException("Insufficient Balance");
                }
                else {
                    ACCBalance = ACCBalance - wd;
                    Console.Writeline("Amount of {0} is withdraw successfully", wd);
                    Console.Writeline("Account Balance is {0}", ACCBalance);
                }
            }
            catch (InSufficientBalanceException se) {
                Console.WriteLine(se.Message);
                Console.WriteLine("Transaction Aborted");
            }
            catch (MinimumBalanceException me)
            {
                Console.WriteLine(me.Message);
                Console.WriteLine("Transaction Aborted");
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                Console.WriteLine("Transaction Aborted");
            }
            finally
                {
                Console.WriteLine("Thanks for visiting");
            }
        }
    }
}
