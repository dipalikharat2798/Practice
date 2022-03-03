using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
namespace Movie
{
    class ValidException : Exception
    {
        public ValidException(string message) : base(message)
        {
        }
    }
    public class Movie1
    {
        public struct Books
        {
            public string Moviename;
            public string dimension;
            public string direct;
            public string runtime;
            public string type;
            public string release;
            //public int tim;
        };

        
        Books Book1;
        Books Book2;
        Books Book3;
        Books Book4;
        public int Playing()
        {
            /*Books Book1;
            Books Book2;
            Books Book3;
            Books Book4;*/
            int i;

            Book1.Moviename = "Dangal";
            Book1.release = "11 Jan 2021";
            Book1.direct = " Nitesh Tiwari";
            Book1.runtime = "2 hr 20min";
            Book1.type = "Drama film";
            Book1.dimension = "2D";

            Book2.Moviename = "2.0";
            Book2.release = "12 Jan 2021";
            Book2.runtime = "2 hr 30min";
            Book2.type = "fiction action film ";
            Book2.direct = " S. Shankar";
            Book2.dimension = "3D";

            Book3.Moviename = "Airlift";
            Book3.release = "12 Jan 2021";
            Book3.runtime = "2 hr 13 min";
            Book3.type = "Action drama film";
            Book3.direct = " Raja Menon";
            Book3.dimension = "2D";

            Book4.Moviename = "K.G.F: Chapter 2";
            Book4.release = "13 Jan 2021";
            Book4.runtime = "2hr 31min";
            Book4.type = "Action Drama film";
            Book4.direct = "Prashanth Neel";
            Book4.dimension = "3D";

            Console.WriteLine("\n\t\t Movie No : {0}", 1);
            Console.WriteLine("\t\t***************");
            Console.WriteLine(" ____________________________________________________________ ");
            Console.WriteLine("\n  Movie Title: " + Book1.Moviename);
            Console.WriteLine("  Release Date : " + Book1.release);
            Console.WriteLine("  Runtime      : " + Book1.runtime);
            Console.WriteLine("  Directed By  : " + Book1.direct);
            Console.WriteLine("  Genre        : " + Book1.type);
            Console.WriteLine("  Screen       : " + Book1.dimension);
            Console.WriteLine(" ____________________________________________________________ ");
            Console.WriteLine();

            Console.WriteLine("\n\t\t Movie No : {0}", 2);
            Console.WriteLine("\t\t***************");
            Console.WriteLine(" ____________________________________________________________ ");
            Console.WriteLine("\n  Movie Title: " + Book2.Moviename);
            Console.WriteLine("  Release Date : " + Book2.release);
            Console.WriteLine("  Runtime      : " + Book2.runtime);
            Console.WriteLine("  Directed By  : " + Book2.direct);
            Console.WriteLine("  Genre        : " + Book2.type);
            Console.WriteLine("  Screen       : " + Book2.dimension);
            Console.WriteLine(" ____________________________________________________________ ");
            Console.WriteLine();

            Console.WriteLine("\n\t\t Movie No : {0}", 3);
            Console.WriteLine("\t\t***************");
            Console.WriteLine(" ____________________________________________________________ ");
            Console.WriteLine("\n  Movie Title: " + Book3.Moviename);
            Console.WriteLine("  Release Date : " + Book3.release);
            Console.WriteLine("  Runtime      : " + Book3.runtime);
            Console.WriteLine("  Directed By  : " + Book3.direct);
            Console.WriteLine("  Genre        : " + Book3.type);
            Console.WriteLine("  Screen       : " + Book3.dimension);
            Console.WriteLine(" ____________________________________________________________ ");
            Console.WriteLine();

            Console.WriteLine("\n\t\t Movie No : {0}", 4);
            Console.WriteLine("\t\t***************");
            Console.WriteLine(" ____________________________________________________________ ");
            Console.WriteLine("\n  Movie Title: " + Book4.Moviename);
            Console.WriteLine("  Release Date : " + Book4.release);
            Console.WriteLine("  Runtime      : " + Book4.runtime);
            Console.WriteLine("  Directed By  : " + Book4.direct);
            Console.WriteLine("  Genre        : " + Book4.type);
            Console.WriteLine("  Screen       : " + Book4.dimension);
            Console.WriteLine(" ____________________________________________________________ ");
            Console.WriteLine();

            Console.WriteLine("\t\t Select the Movie: ");
            Console.WriteLine("\t\t Select 1 for Movie1 \n\t\t Select 2 for Movie2 \n\t\t Select 3 for Movie3 \n\t\t Select 4" +
                    " for Movie4");
            i = Convert.ToInt32(Console.ReadLine());
           
                    if (i == 1)
                    {

                        Console.WriteLine("\n\t Your Seat is Booked ");
                        Console.WriteLine(" _____________________________________");
                        Console.WriteLine("\n  Movie Title: " + Book1.Moviename);
                        Console.WriteLine("  Release Date : " + Book1.release);
                        Console.WriteLine("  Runtime      : " + Book1.runtime);
                        Console.WriteLine("  Directed By  : " + Book1.direct);
                        Console.WriteLine("  Genre        : " + Book1.type);
                        Console.WriteLine("  Screen       : " + Book1.dimension);
                        Console.WriteLine();


                    }
                    if (i == 2)
                    {

                       Console.WriteLine("\n\t Your Seat is Booked ");
                       Console.WriteLine(" _____________________________________");
                        Console.WriteLine("\n  Movie Title: " + Book2.Moviename);
                        Console.WriteLine("  Release Date : " + Book2.release);
                        Console.WriteLine("  Runtime      : " + Book2.runtime);
                        Console.WriteLine("  Directed By  : " + Book2.direct);
                        Console.WriteLine("  Genre        : " + Book2.type);
                        Console.WriteLine("  Screen       : " + Book2.dimension);
                        Console.WriteLine();

                    }
                    if (i == 3)
                    {

                Console.WriteLine("\n\t Your Seat is Booked ");
                Console.WriteLine(" _____________________________________");
                Console.WriteLine("\n  Movie Title: " + Book3.Moviename);
                        Console.WriteLine("  Release Date : " + Book3.release);
                        Console.WriteLine("  Runtime      : " + Book3.runtime);
                        Console.WriteLine("  Directed By  : " + Book3.direct);
                        Console.WriteLine("  Genre        : " + Book3.type);
                        Console.WriteLine("  Screen       : " + Book3.dimension);
                        Console.WriteLine();

                    }
                    if (i == 4)
                    {

                        Console.WriteLine("\n\t Your Seat is Booked");
                        Console.WriteLine(" _____________________________________");
                        Console.WriteLine("\n  Movie Title: " + Book4.Moviename);
                        Console.WriteLine("  Release Date : " + Book4.release);
                        Console.WriteLine("  Runtime      : " + Book4.runtime);
                        Console.WriteLine("  Directed By  : " + Book4.direct);
                        Console.WriteLine("  Genre        : " + Book4.type);
                        Console.WriteLine("  Screen       : " + Book4.dimension);
                        Console.WriteLine(" _____________________________________");
                        Console.WriteLine();

                    }
              
            return i;
        }
       
    }
}

