using System;
using System.Collections.Generic;
using System.Data;
using System.Text;

namespace Linq_proj
{
    class Class9
    {
       
            static void Main(string[] args)
            {
                SqlConnection conn = new SqlConnection("Data Source=(localdb)\\mssqllocaldb; Initial Catalog = VMDB1; Integrated Security= true");
                SqlDataAdapter adpt = new SqlDataAdapter("select * from Employee", conn);
                DataSet ds = new DataSet();
                adpt.Fill(ds, "Emp");

                DataTable datatable = ds.Tables["Emp"];
                var dtable = datatable.AsEnumerable(); // because DataTable does not implement any IEnumerable<T> interface
                                                       // we have to invoke AsEnumerable() method.
                var query = from emp in dtable
                            orderby emp["Salary"].ToString() descending
                            select emp;

                foreach (var e in query)
                {
                    DataRow row = (DataRow)e;
                    Console.WriteLine("{0,-4}{1, -13}{2, -6}", row["EmpId"], row["EmpName"], row["Salary"]);
                }

                Console.ReadLine();
            }
        }


    }

