using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DB_App
{
    class RetriveEmpData
    {
        static void Main(string[] args)
        {
            string query;
            SqlConnection con;
            SqlCommand cmd;
            SqlDataReader sdr;
            string Edesig;
            string Edept;
            string Eloc;
            int choice;

            Console.WriteLine("Enter the choice");
            Console.WriteLine("1.Employee by department");
            Console.WriteLine("2.Employee by location");
            Console.WriteLine("3.Employee by designation");
            choice = Convert.ToInt32(Console.ReadLine());

            con = new SqlConnection();
            con.ConnectionString = "Server=(localdb)\\mssqllocaldb;Database=VMDB1;Integrated Security=true ";
            //Console.WriteLine("Connection Established");
            con.Open();
            // Console.WriteLine("Connection opened...");

            if (choice == 1) {

                Console.WriteLine("Enter the Department");
                Edept = Console.ReadLine();
              //  con.Open();
                query = "select * from Employee Where Department= @Edept";

                cmd = new SqlCommand(query, con);
                Console.WriteLine("Connection executed...");

                cmd.Parameters.Add(new SqlParameter("@Edept", SqlDbType.VarChar));
                cmd.Parameters["@Edept"].Value = Edept;

                sdr = cmd.ExecuteReader();
                while (sdr.Read())
                {
                    Console.WriteLine("EmpId:{0} Name:{1} Designation:{2} Department:{3} Location:{4}", sdr[0], sdr[1], sdr[2], sdr[3], sdr[4]);
                }
                Console.ReadKey();
            }
            else if (choice == 1)
            {
         
                Console.WriteLine("Enter the location ");
                Eloc = Console.ReadLine();
               // con.Open();
                query = "select * from Student Where Location:@Eloc";

                cmd = new SqlCommand(query, con);
                Console.WriteLine("Connection executed...");

                cmd.Parameters.Add(new SqlParameter("@Eloc", SqlDbType.VarChar));
                cmd.Parameters["@Ename"].Value = Eloc;
                sdr = cmd.ExecuteReader();
                sdr = cmd.ExecuteReader();
                while (sdr.Read())
                {
                    Console.WriteLine("EmpId:{0} Name:{1} Designation:{2} Department:{3} Location:{4}", sdr[0], sdr[1], sdr[2], sdr[3], sdr[4]);
                }
                Console.ReadKey();
            }
            else
            {
                Console.WriteLine("Enter the designation ");
                Edesig = Console.ReadLine();
                con.Open();
                query = "select * from Student Where Designatin=@Edesig";

                cmd = new SqlCommand(query, con);
                Console.WriteLine("Connection executed...");

                cmd.Parameters.Add(new SqlParameter("@Edesig", SqlDbType.VarChar));
                cmd.Parameters["Edesig"].Value = Edesig;

                sdr = cmd.ExecuteReader();
                while (sdr.Read())
                {
                    Console.WriteLine("EmpId:{0} Name:{1} Designation:{2} Department:{3} Location:{4}", sdr[0], sdr[1], sdr[2], sdr[3], sdr[4]);
                }
                Console.ReadKey();
            }
            

           
            Console.ReadKey();
        }
    }
}
