using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;

namespace StoredProc
{
    class Class1
    {
        
            SqlConnection con;
            SqlCommand cmd;
            SqlDataReader sdr;
            string query;
            int rows;

            public Class1()
            {
                con = new SqlConnection("Data Source=(localdb)\\mssqllocaldb; Initial Catalog=VMDB;Integrated Security=true");
            }

            public void DisplayAllStudents()
            {
                con.Open();
            cmd = new SqlCommand("SelectAllStudents", con);
            cmd.CommandType = System.Data.CommandType.StoredProcedure;
            sdr = cmd.ExecuteReader(); //Select query

                while (sdr.Read())
                {
                Console.WriteLine("Id:{0} Name:{1} Marks:{2}", sdr[0], sdr[1], sdr[2]);
                }
            con.Close();
            }

            public void DisplayStudentByID()
            {
                Console.WriteLine("Enter Id marks");
                int Id = Convert.ToInt32(Console.ReadLine());

                con.Open();
            cmd = new SqlCommand("GetStudentById", con);
            cmd.CommandType = System.Data.CommandType.StoredProcedure;

            cmd.Parameters.AddWithValue("@Id", Id);
                sdr = cmd.ExecuteReader(); //Select query

                while (sdr.Read())
                {
                Console.WriteLine("Id:{0} Name:{1} Marks:{2}", sdr[0], sdr[1], sdr[2]);
            }
                con.Close();
            }

            public void AddStudent()
            {
                Console.WriteLine("Enter Id Name marks");
                int Id = Convert.ToInt32(Console.ReadLine());
                string Name = Console.ReadLine();
                int Marks = Convert.ToInt32(Console.ReadLine());

                con.Open();
            cmd = new SqlCommand("AddStudent", con);
            cmd.CommandType = System.Data.CommandType.StoredProcedure;

            cmd.Parameters.AddWithValue("@id", Id);
                cmd.Parameters.AddWithValue("@name", Name);
                cmd.Parameters.AddWithValue("@marks", Marks);
            rows = cmd.ExecuteNonQuery();
            Console.WriteLine("{0} rows inserted", rows);
                con.Close();
            }

            public void DeleteStudent()
            {
                Console.WriteLine("Enter Id marks");
                int Id = Convert.ToInt32(Console.ReadLine());

                con.Open();
            cmd = new SqlCommand("DeleteStudent", con);
            cmd.CommandType = System.Data.CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@Id", Id);

            rows = cmd.ExecuteNonQuery();
            Console.WriteLine("{0} rows deleted", rows);
            con.Close();
            }

            public void UpdateStudent()
            {
                Console.WriteLine("Enter Id marks");
                int Id = Convert.ToInt32(Console.ReadLine());
                int Marks = Convert.ToInt32(Console.ReadLine());

                con.Open();
                query = "Update Student set Marks=@marks where Id=@Id";
                cmd = new SqlCommand(query, con);

                cmd.Parameters.AddWithValue("@Id", Id);
                cmd.Parameters.AddWithValue("@marks", Marks);
            rows = cmd.ExecuteNonQuery();
            Console.WriteLine("{0} rows updated", rows);
            con.Close();
            }
        }
    }

