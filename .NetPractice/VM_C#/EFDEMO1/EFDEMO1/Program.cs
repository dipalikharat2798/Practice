using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EFDEMO1
{
    class Program
    {
        
            static void Main(string[] args)
            {
                char ch = 'y';



                do
                {



                    Class1 obj = new Class1();
                    obj.Menu();




                    switch (obj.choice)
                    {
                        case 1:
                            obj.GetAllStudents();
                            break;



                        case 2:
                            obj.AddStudent();
                            break;



                        case 3:
                            obj.UpdateStudent();
                            break;




                        case 4:
                            obj.DeleteStudent();
                            break;



                        case 5:
                            obj.GetStudentById();
                            break;

                        default:
                            Console.WriteLine("Invalid choice");
                            break;
                    }
                    Console.WriteLine("Do you want to contine y/n");
                    ch = Convert.ToChar(Console.ReadLine());
                }
                while (ch == 'y');



                Console.ReadLine();
            }
        }
    }
    

