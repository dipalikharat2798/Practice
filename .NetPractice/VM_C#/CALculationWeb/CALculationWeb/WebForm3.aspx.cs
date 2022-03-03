using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CALculationWeb
{
    public partial class WebForm3 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void ListBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            ListBox2.Items.Add(ListBox1.SelectedItem.ToString());
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            ListBox2.Items.Remove(ListBox2.SelectedItem.ToString());
        }

        protected void Button3_Click(object sender, EventArgs e)
        {

        }
    }
}