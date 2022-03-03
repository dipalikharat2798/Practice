using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DB_App
{
    class Program
    {
        static void Main(string[] args)
        {
            string query;
            SqlConnection con;
            SqlCommand cmd;
            SqlDataReader sdr;

            con = new SqlConnection();

            con.ConnectionString = "Server=(localdb)\\mssqllocaldb;Database=VMDB1;Integrated Security=true ";
            Console.WriteLine("Connection Established");
            con.Open();
            Console.WriteLine("Connection opened...");
            query = "select * from Student";
            cmd = new SqlCommand(query, con);
            Console.WriteLine("Connection executed...");
            sdr = cmd.ExecuteReader();

            while (sdr.Read()) {
                Console.WriteLine("Id :{0}  Name:{1} Marks:{2}",sdr[0],sdr[1],sdr[2]);
            }
            Console.ReadKey();
        }
    }
}