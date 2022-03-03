using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sql
{
    class EmployeeDemo
    {
        static void Main(string[] args)
        {
            string query;
            SqlConnection con;
            SqlCommand cmd;
            SqlDataReader sdr;
            int ch;
            Console.WriteLine("Enter your choice: ");
            Console.WriteLine(" ");
            Console.WriteLine("1.Employees by Department");
            Console.WriteLine("2.Employees by Location");
            Console.WriteLine("3.Employees by Designation");
            Console.WriteLine(" ");
            
            ch = Convert.ToInt32(Console.ReadLine());

            con = new SqlConnection();
            con.ConnectionString = "Data Source=(localdb)\\mssqllocaldb;Initial Catalog=VMDB;Integrated Security=true";
            Console.WriteLine("Connection established ...");
            con.Open();
            Console.WriteLine("Connection opened ...");

            switch(ch)
            {
                case 1:
                    Console.WriteLine("Enter Department");
                    string department = Console.ReadLine();
                    query = "select * from Employee Where Department=@department";

                    cmd = new SqlCommand(query, con);
                    cmd.Parameters.AddWithValue("@Department",department);

                    sdr = cmd.ExecuteReader();

                    while (sdr.Read())
                    {
                        Console.WriteLine("Id:{0} Name:{1}    Designation:{2}    Department:{3}     Location:{4}", sdr[0], sdr[1], sdr[2],sdr[3],sdr[4]);
                    }
                    break;

                case 2:
                    Console.WriteLine("Enter Location");
                    string location = Console.ReadLine();
                    query = "select * from Employee Where Location=@location";

                    cmd = new SqlCommand(query, con);
                    cmd.Parameters.AddWithValue("@Location", location);

                    sdr = cmd.ExecuteReader();

                    while (sdr.Read())
                    {
                        Console.WriteLine("Id:{0} Name:{1}  Designation:{2}  Department:{3}  Location:{4}", sdr[0], sdr[1], sdr[2], sdr[3], sdr[4]);
                    }
                    break;

                case 3:
                    Console.WriteLine("Enter Designation");
                    string designation = Console.ReadLine();
                    query = "select * from Employee Where Designation=@designation";

                    cmd = new SqlCommand(query, con);
                    cmd.Parameters.AddWithValue("@Designation",designation);

                    sdr = cmd.ExecuteReader();

                    while (sdr.Read())
                    {
                        Console.WriteLine("Id:{0} Name:{1}  Designation:{2}  Department:{3}  Location:{4}", sdr[0], sdr[1], sdr[2], sdr[3], sdr[4]);
                    }
                    break;

                default:
                    Console.WriteLine("Invalid Choice");
                    break;

            }
            Console.ReadKey();
        }
    }
}
