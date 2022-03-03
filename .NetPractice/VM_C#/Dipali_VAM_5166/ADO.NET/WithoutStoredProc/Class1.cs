using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sql
{
    class Class1
    {
        static void Main(string[] args)
        {
            string query;
            SqlConnection con;
            SqlDataAdapter adap;
            DataSet ds;

            // con = new SqlConnection("Server=(localdb)\\mssqllocaldb;Database=VMDB;Integrated Security=true");

            con = new SqlConnection("Data Source = (localdb)\\mssqllocaldb; Initial Catalog = VMDB; Integrated Security = true");

            Console.WriteLine("Connection established ...");

            query = "select * from Student";

            adap = new SqlDataAdapter(query, con);

            ds = new DataSet();

            adap.Fill(ds, "Student");
            Console.WriteLine("Command executed ...");

           foreach(DataRow dr in ds.Tables["Student"].AsEnumerable())
            {
                Console.WriteLine("Id:{0} Name:{1} Marks:{2}",dr[0],dr["Name"],dr[2]);
            }
 
            Console.ReadKey();



        }
    }
}
