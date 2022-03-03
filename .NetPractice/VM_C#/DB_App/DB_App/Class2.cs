using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DB_App
{
    class Class2
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
            Console.WriteLine("Enter Marks");
            marks = Convert.ToInt32(Console.ReadLine());
            con = new SqlConnection();


            con.ConnectionString = "Server=(localdb)\\mssqllocaldb;Database=VMDB1;Integrated Security=true ";
            Console.WriteLine("Connection Established");
            con.Open();
            Console.WriteLine("Connection opened...");

            query = "select * from Student Where Name='" + name + "'";
            //query = "select * from Student Where Name='" + name + "' and Marks="+marks;
           // query = "select * from Student Where Name= @name and Marks=@marks";
            //query = "select * from Student";
            cmd = new SqlCommand(query, con);
            Console.WriteLine("Connection executed...");

            cmd.Parameters.Add(new SqlParameter("@name",SqlDbType.VarChar));
            cmd.Parameters["@name"].Value = name;
            sdr = cmd.ExecuteReader();

            while (sdr.Read())
            {
                Console.WriteLine("Id :{0}  Name:{1} Marks:{2}", sdr[0], sdr[1], sdr[2]);
            }
            Console.ReadKey();
        }
    }
}
