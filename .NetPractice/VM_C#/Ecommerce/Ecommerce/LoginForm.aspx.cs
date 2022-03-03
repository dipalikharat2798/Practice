using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Ecommerce
{
    public partial class LoginForm : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

       

        protected void ButLogin_Click(object sender, EventArgs e)
        {
            string username = TxtUserName.Text;
            string password = TxtPassword.Text;
            if (username.Equals("Dipali") && password.Equals("123"))
                Response.Redirect("EHome.aspx");
            else
                Response.Redirect("Invalid username and password");
        }
    }
}