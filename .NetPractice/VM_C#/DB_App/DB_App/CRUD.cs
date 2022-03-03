using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DB_App
{
    class CRUD
    {
        SqlConnection con;
        SqlCommand cmd;
        SqlDataReader sdr;
        //string query;
        int rows;

        public CRUD()
        {
            con = new SqlConnection("Data Source=(localdb)\\mssqllocaldb; Initial Catalog=VMDB1;Integrated Security=true");
        }



        public void DisplayAllStudents()
        {
            con.Open();
            //  query = "select * from Student";
            // cmd = new SqlCommand(query, con);
            cmd = new SqlCommand("SelectAllStudents",con);
            cmd.CommandType = System.Data.CommandType.StoredProcedure;
            sdr = cmd.ExecuteReader(); //Select query



            while (sdr.Read())
            {
                Console.WriteLine("Id : {0}  Name : {1}  Marks : {2}", sdr[0], sdr["Name"], sdr[2]);
            }
            con.Close();
        }



        public void DisplayStudentByID()
        {
            Console.WriteLine("Enter Id marks");
            int Id = Convert.ToInt32(Console.ReadLine());



            con.Open();
            // query = "select * from Student where Id=@Id";
            // cmd = new SqlCommand(query, con);

            cmd = new SqlCommand("GetStudentById", con);
            cmd.CommandType = System.Data.CommandType.StoredProcedure;

             cmd.Parameters.AddWithValue("@Id", Id);
            sdr = cmd.ExecuteReader(); //Select query



            while (sdr.Read())
            {
                Console.WriteLine("Id : {0}  Name : {1}  Marks : {2}", sdr[0], sdr["Name"], sdr[2]);
            }
            con.Close();
        }



        public void AddStudent()
        {
            Console.WriteLine("Enter Id, Name, marks");

            int id = Convert.ToInt32(Console.ReadLine());
            string Name = Console.ReadLine();
            int marks = Convert.ToInt32(Console.ReadLine());



            con.Open();
            //  query = "insert into Student Values(@id, @name, @marks)";
            //  cmd = new SqlCommand(query, con);
            cmd = new SqlCommand("AddStudent", con);
            cmd.CommandType = System.Data.CommandType.StoredProcedure;


            cmd.Parameters.AddWithValue("@id", id);
            cmd.Parameters.AddWithValue("@name", Name);
            cmd.Parameters.AddWithValue("@marks", marks);

            rows = cmd.ExecuteNonQuery();
            Console.WriteLine("{0} rows inserted", rows);
            con.Close();
        }



        public void DeleteStudent()
        {
            Console.WriteLine("Enter Id marks");
            int Id = Convert.ToInt32(Console.ReadLine());




            con.Open();
            //  query = "Delete from Student where Id=@Id";
            //  cmd = new SqlCommand(query, con);

            cmd = new SqlCommand("DeleteStudent", con);
            cmd.CommandType = System.Data.CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@Id", Id);
            //cmd.Parameters.AddWithValue("@Id", Id);
            rows = cmd.ExecuteNonQuery();
            Console.WriteLine("{0} rows Deleted", rows);
            con.Close();
        }



        public void UpdateStudent()
        {
            Console.WriteLine("Enter Id marks");
            int Id = Convert.ToInt32(Console.ReadLine());
            int Marks = Convert.ToInt32(Console.ReadLine());



            con.Open();
            //  query = "Update Student set Marks=@marks where Id=@Id";
            // cmd = new SqlCommand(query, con);

            cmd = new SqlCommand("UpdateStudents", con);
            cmd.CommandType = System.Data.CommandType.StoredProcedure;

           cmd.Parameters.AddWithValue("@Id", Id);
           cmd.Parameters.AddWithValue("@marks", Marks);
            rows = cmd.ExecuteNonQuery();
            Console.WriteLine("{0} rows Updated", rows);
            con.Close();
        }
        public void UpdateStudent()
        {
            Console.WriteLine("Enter Id marks");
            int Id = Convert.ToInt32(Console.ReadLine());
            int Marks = Convert.ToInt32(Console.ReadLine());



            con.Open();
            



            cmd.Parameters.AddWithValue("@Id", Id);
            cmd.Parameters.AddWithValue("@marks", Marks);
            rows = cmd.ExecuteNonQuery();
            Console.WriteLine("{0} rows updated", rows);
            con.Close();
        }
    }
}

