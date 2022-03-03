using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sql
{
    class Class3
    {
        SqlConnection con;
        SqlCommand cmd;
        SqlDataReader sdr;
        string query;
        int rows;

        public Class3()
        {
            con = new SqlConnection("Data Source=(localdb)\\mssqllocaldb;Initial Catalog=VMDB;Integrated Security=true");
        }

        public void DisplayAllStudents()
        {
            con.Open();
            query = "select * from Student";
            cmd = new SqlCommand(query, con);
            sdr = cmd.ExecuteReader();

            while (sdr.Read())
            {
                Console.WriteLine("Id:{0}  Name:{1}  Marks:{2}", sdr[0], sdr[1], sdr[2]);
            }
            con.Close();
                
        }

        public void DisplayStudentByID()
        {
            Console.WriteLine("Enter Id ");
            int Id = Convert.ToInt32(Console.ReadLine());

            con.Open();
            query = "select * from Student where Id=@Id";
            cmd = new SqlCommand(query,con);

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
            query = "insert into Student Values(@Id, @Name, @Marks)";
            cmd = new SqlCommand(query, con);

            cmd.Parameters.AddWithValue("@Id", Id);
            cmd.Parameters.AddWithValue("@Name", Name);
            cmd.Parameters.AddWithValue("@Marks", Marks);
            rows = cmd.ExecuteNonQuery();
            Console.WriteLine("{0} rows inserted", rows);
            con.Close();
        }


        public void DeleteStudent()
        {
            Console.WriteLine("Enter Id marks");
            int Id = Convert.ToInt32(Console.ReadLine());

            con.Open();
            query = "Delete from Student where Id=@Id";
            cmd = new SqlCommand(query, con);

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
            cmd.Parameters.AddWithValue("@Marks", Marks);
            rows = cmd.ExecuteNonQuery();
            Console.WriteLine("{0} rows updated", rows);
            con.Close();
        }
    }
}

