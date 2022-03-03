using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CALculationWeb
{
    public partial class form1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            LstBooks.Items.Add("b1");
            LstBooks.Items.Add("b2");
        }

        protected void ListBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            Label1.Text = ListBox1.SelectedItem.ToString();
        }

        protected void ListBox2_SelectedIndexChanged(object sender, EventArgs e)
        {
           Label2.Text = LstBooks.SelectedItem.ToString();
        }
    }
}