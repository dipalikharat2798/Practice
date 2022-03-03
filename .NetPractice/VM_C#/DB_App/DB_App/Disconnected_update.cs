using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DB_App
{
    class Disconnected_update
    {
        SqlConnection con;
        SqlDataAdapter adap;
        SqlDataReader sdr;
        string query;
        int rows;
        DataSet ds;
        SqlCommandBuilder scb;


        public Disconnected_update()
        {
            con = new SqlConnection("Data Source=(localdb)\\mssqllocaldb; Initial Catalog=VMDB;Integrated Security=true");
            query = "select * from Student";

            adap = new SqlDataAdapter(query, con);
            adap.MissingSchemaAction = MissingSchemaAction.AddWithKey;



            scb = new SqlCommandBuilder(adap);

            ds = new DataSet();

            adap.Fill(ds, "Student");

        }



        public void DisplayAllStudents()
        {
            DataTable dt = ds.Tables[0];



            foreach (DataRow dr in dt.AsEnumerable())
            {
                Console.WriteLine("Id : {0}  Name : {1}  Marks : {2}", dr[0], dr["Name"], dr[2]);
            }
        }



        public void DisplayStudentByID()
        {
            Console.WriteLine("Enter Id marks");
            int Id = Convert.ToInt32(Console.ReadLine());



            DataView dv = new DataView();
            dv.Table = ds.Tables["Student"];
            dv.RowFilter = "Id = " + Id;



            foreach (DataRowView dr in dv)
            {
                Console.WriteLine("Id : {0}  Name : {1}  Marks : {2}", dr[0], dr["Name"], dr[2]);
            }



        }



        public void AddStudent()
        {
            Console.WriteLine("Enter Id Name marks");
            int Id = Convert.ToInt32(Console.ReadLine());
            string Name = Console.ReadLine();
            int Marks = Convert.ToInt32(Console.ReadLine());



            DataTable dt = ds.Tables[0];
            DataRow dr = dt.NewRow();
            dr[0] = Id;
            dr[1] = Name;
            dr[2] = Marks;
            dt.Rows.Add(dr);



            adap.Update(ds, "Student");
            adap.Fill(ds, "Student");
        }



        public void DeleteStudent()
        {
            Console.WriteLine("Enter Id");
            int Id = Convert.ToInt32(Console.ReadLine());



            DataTable dt = ds.Tables[0];
            DataRow dr = dt.Rows.Find(Id);
            dt.Rows.Remove(dr);



            adap.Update(ds, "Student");
            adap.Fill(ds, "Student");
        }



        public void UpdateStudent()
        {
            Console.WriteLine("Enter Id marks");
            int Id = Convert.ToInt32(Console.ReadLine());
            int Marks = Convert.ToInt32(Console.ReadLine());



            DataTable dt = ds.Tables[0];
            DataRow dr = dt.Rows.Find(Id);
            dr.BeginEdit();
            dr[2] = Marks;
            dr.EndEdit();



            adap.Update(ds, "Student");
            adap.Fill(ds, "Student");
        }
    }
}

