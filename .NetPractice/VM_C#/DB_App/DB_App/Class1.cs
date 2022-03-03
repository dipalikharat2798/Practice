using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DB_App
{
    class Class1
    {
        static void Main(string[] args)
        {
            string query;
            SqlConnection con;
            SqlDataAdapter adap;
            DataSet ds;

           // con = new SqlConnection();

            con= new SqlConnection("Server=(localdb)\\mssqllocaldb;Database=VMDB1;Integrated Security=true ");
            Console.WriteLine("Connection Established");
        
            query = "select * from Student";

            adap = new SqlDataAdapter(query, con);

            ds = new DataSet();

            adap.Fill(ds,"Student");

            Console.WriteLine("Command Executed...");
            foreach(DataRow dr in ds.Tables["Student"].AsEnumerable())
            {
                Console.WriteLine("Id :{0}  Name:{1} Marks:{2}", dr[0], dr[1], dr[2]);
            }
            Console.ReadKey();
        }
    }
}
