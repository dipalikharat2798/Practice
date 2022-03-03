using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sql
{
    class Parameters
    {
        static void Main(string[] args)
        {
            string query;
            SqlConnection con;
            SqlCommand cmd;
            SqlDataReader sdr;
            string name;
            int marks;

            Console.WriteLine("Enter a name");
            name = Console.ReadLine();
            Console.WriteLine("Enter marks");
            marks = Convert.ToInt32(Console.ReadLine());

            con = new SqlConnection();

            //    con.ConnectionString = "Server=(localdb)\\mssqllocaldb;Database=VMDB;Integrated Security=true";

            con.ConnectionString = "Data Source=(localdb)\\mssqllocaldb;Initial Catalog=VMDB;Integrated Security=true";
            Console.WriteLine("Connection established ...");
            con.Open();
            Console.WriteLine("Connection opened ...");

            //  query = "select * from Student Where Name ='" + name + "'";
            //  query = "select * from Student where Name= '" + name +"' and Marks = " + marks;
            query = "select * from Student Where Name = @name and Marks =@marks";

            cmd = new SqlCommand(query, con);
            Console.WriteLine("Command executed ...");


            cmd.Parameters.Add(new SqlParameter("@name", SqlDbType.VarChar));
            cmd.Parameters["@name"].Value = name;

            //            cmd.Parameters.Add(new SqlParameter("@marks", marks));

            cmd.Parameters.AddWithValue("@marks", marks);

            sdr = cmd.ExecuteReader();

            while (sdr.Read())
            {
                Console.WriteLine("Id:{0} Name:{1} Marks:{2}", sdr[0], sdr[1], sdr[2]);
            }
            Console.ReadKey();
        }
    }
}

