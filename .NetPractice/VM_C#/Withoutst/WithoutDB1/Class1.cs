using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WithoutDB1
{
    class Class1
    {
        public int choice;
        int Id;
        string Name;
        float w;
        float h;




        VMSchoolDB db;
        Student s;



        public Class1()
        {
            db = new VMSchoolDB();
        }



        public void GetAllStudents()
        {
            Console.WriteLine("Displaying all students");
            foreach (var std in db.Students)
            {
                Console.WriteLine("{0} {1} {2} {3}", std.StudentID, std.StudentName, std.Height, std.Weight);
            }



        }




        public void AddStudent()
        {
            Console.WriteLine("Enter id Name weight height");
            Id = Convert.ToInt32(Console.ReadLine());
            Name = Console.ReadLine();
            w = Convert.ToSingle(Console.ReadLine());
            h = Convert.ToSingle(Console.ReadLine());



            Student s1 = db.Students.Where(std => std.StudentID == Id).SingleOrDefault();



            if (s1 == null)
            {
                s = new Student() { StudentID = Id, StudentName = Name, Weight = w, Height = h };
                // db.Students.InsertOnSubmit(s);
                db.Students.Add(s);
                //db.SubmitChanges();
                db.SaveChanges();



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
            s = db.Students.Where(std => std.StudentID == Id).SingleOrDefault();



            if (s != null)
            {
                Console.WriteLine("Enter the height and weight");
                w = Convert.ToSingle(Console.ReadLine());
                h = Convert.ToSingle(Console.ReadLine());



                s.Height = h;
                s.Weight = w;
                //db.SubmitChanges();
                db.SaveChanges();



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



            s = db.Students.Where(std => std.StudentID == Id).SingleOrDefault();



            if (s != null)
            {
                Console.WriteLine("Are you sure your want to delete y/n");
                char c = Convert.ToChar(Console.ReadLine().ToLower());
                if (c == 'y')
                {
                    //    db.Students.DeleteOnSubmit(s);
                    //   db.SubmitChanges();



                    db.Students.Remove(s);
                    db.SaveChanges();



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



            s = db.Students.Where(std => std.StudentID == Id).SingleOrDefault();



            if (s != null)
            {
                Console.WriteLine("{0} {1} {2} {3}", s.StudentID, s.StudentName, s.Height, s.Weight);
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
