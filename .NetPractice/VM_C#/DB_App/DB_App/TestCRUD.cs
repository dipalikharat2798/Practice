using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DB_App
{
    class TestCRUD
    {
        static void Main(string[] args)
        {



            char ch = 'y';



            do
            {
                int choice;



                Console.WriteLine("1.Display All Students");
                Console.WriteLine("2.Student By Id");
                Console.WriteLine("3.Add new Student");
                Console.WriteLine("4.Update MArks");
                Console.WriteLine("5.Delete student");
                Console.WriteLine("6.Select an option");
                choice = Convert.ToInt32(Console.ReadLine());




                CRUD obj = new CRUD();



                switch (choice)
                {
                    case 1:
                        obj.DisplayAllStudents();
                        break;
                    case 2:
                        obj.DisplayStudentByID();
                        break;
                    case 3:
                        obj.AddStudent();
                        break;
                    case 4:
                        obj.UpdateStudent();
                        break;
                    case 5:
                        obj.DeleteStudent();
                        break;
                    default:
                        Console.WriteLine("Invalid choice");
                        break;
                }
                Console.WriteLine("Do you want to continue y/n");
                ch = Convert.ToChar(Console.ReadLine().ToLower());
            }
            while (ch == 'y');
            Console.ReadLine();
        }
    }
}
