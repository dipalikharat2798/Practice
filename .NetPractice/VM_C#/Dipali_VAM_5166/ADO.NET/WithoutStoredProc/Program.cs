using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sql
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

            //    con.ConnectionString = "Server=(localdb)\\mssqllocaldb;Database=VMDB;Integrated Security=true";

            con.ConnectionString = "Data Source=(localdb)\\mssqllocaldb;Initial Catalog=VMDB;Integrated Security=true";
            Console.WriteLine("Connection established ...");
            con.Open();
            Console.WriteLine("Connection opened ...");
            query = "select * from Student";

            cmd = new SqlCommand(query, con);
            Console.WriteLine("Command executed ...");
            sdr = cmd.ExecuteReader();

            while(sdr.Read())
            {
                Console.WriteLine("Id: {0} Name:{1} Marks:{2}",sdr[0],sdr[1],sdr[2]);
            }
            Console.ReadKey();
           
        }
    }
}
