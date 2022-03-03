using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CALculationWeb
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void RadioButton3_CheckedChanged(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            var message = "";
            if (RadioButton1.Checked)
            {
                message = RadioButton1.Text + " ";
            }
            if (RadioButton2.Checked)
            {
                message += RadioButton2.Text + " ";
            }
            if (RadioButton3.Checked)
            {
                message += RadioButton3.Text;
            }
            TextBox1.Text = "Technology is " + message;

           
        }
    }
}