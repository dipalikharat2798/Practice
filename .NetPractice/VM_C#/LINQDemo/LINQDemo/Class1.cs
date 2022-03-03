using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LINQDemo
{
    class Class1
    {
        public int choice;
        int Id;
        string Name;
        int Marks;



        StudentDataContext db;
        Student s;



        public Class1()
        {
            db = new StudentDataContext();
        }



        public void GetAllStudents()
        {
            Console.WriteLine("Displaying all students");
            foreach (var std in db.Students)
            {
                Console.WriteLine("{0} {1} {2}", std.Id, std.Name, std.Marks);
            }



        }




        public void AddStudent()
        {
            Console.WriteLine("Enter id Name and Marks");
            Id = Convert.ToInt32(Console.ReadLine());
            Name = Console.ReadLine();
            Marks = Convert.ToInt32(Console.ReadLine());



            Student s1 = db.Students.Where(std => std.Id == Id).SingleOrDefault();



            if (s1 == null)
            {
                s = new Student() { Id = Id, Name = Name, Marks = Marks };
                db.Students.InsertOnSubmit(s);
                db.SubmitChanges();



                Console.WriteLine("New Student added to database");
            }
            else
            {
                Console.WriteLine("Student already exists with this is ");
            }
        }




        public void UpdateStudent()
        {
            Console.WriteLine("Enter id Name");
            Id = Convert.ToInt32(Console.ReadLine());
            s = db.Students.Where(std => std.Id == Id).SingleOrDefault();



            if (s != null)
            {
                Console.WriteLine("Enter the new marks");
                Marks = Convert.ToInt32(Console.ReadLine());
                s.Marks = Marks;
                db.SubmitChanges();



                Console.WriteLine("Replaced old marks with new marks");
            }
            else
            {
                Console.WriteLine("No such student exists");
            }




        }




        public void DeleteStudent()
        {
            Console.WriteLine("Enter id Name");
            Id = Convert.ToInt32(Console.ReadLine());



            s = db.Students.Where(std => std.Id == Id).SingleOrDefault();



            if (s != null)
            {
                Console.WriteLine("Are you sure your want to delete y/n");
                char c = Convert.ToChar(Console.ReadLine().ToLower());
                if (c == 'y')
                {
                    db.Students.DeleteOnSubmit(s);
                    db.SubmitChanges();



                    Console.WriteLine("Student with id {0} deleted", Id);
                }
            }
            else
            {
                Console.WriteLine("No such student exists");
            }



        }




        public void GetStudentById()
        {
            Console.WriteLine("Enter id Name");
            Id = Convert.ToInt32(Console.ReadLine());



            s = db.Students.Where(std => std.Id == Id).SingleOrDefault();



            if (s != null)
            {
                Console.WriteLine("{0} {1} {2}", s.Id, s.Name, s.Marks);
            }
            else
            {
                Console.WriteLine("No such student exists");
            }
        }




        public void Menu()
        {
            Console.Clear();
            Console.WriteLine("1.Get All Students\n" +
               "2. Add student\n 3.Update Marks \n 4. Delete Student" +
               "\n 5. Get Student By ID");
            Console.WriteLine("Select an options");
            choice = Convert.ToInt32(Console.ReadLine());



        }
    }
}
