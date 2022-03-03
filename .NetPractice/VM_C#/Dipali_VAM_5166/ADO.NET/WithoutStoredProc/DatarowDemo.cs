using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sql
{
    class DatarowDemo
    {
        static void Main(string[] args)
        {
            string query;
            SqlConnection con;
            SqlDataAdapter adap;
            DataSet ds;
            string name;
            Console.WriteLine("Enter name");
            name = Console.ReadLine();

            con = new SqlConnection("Data Source = (localdb)\\mssqllocaldb; Initial Catalog = VMDB; Integrated Security = true");

            Console.WriteLine("Connection established ...");


            query = "select * from Student";

            adap = new SqlDataAdapter(query, con);

            ds = new DataSet();

            adap.Fill(ds, "Student");

            DataView dv = new DataView();
            dv.Table = ds.Tables["Student"];
            dv.RowFilter = "Name  = '" + name + "'";
            foreach (DataRowView dr in dv)
            {
                Console.WriteLine("Id:{0}  Name:{1}  Marks:{2}", dr[0], dr[1], dr[2]);
            }
            Console.ReadKey();
        }
    }
}

    

