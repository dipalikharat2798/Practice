using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CALculationWeb
{
    public partial class CalculationHome : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void TextBox1_TextChanged(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            int num1 = Convert.ToInt32(TxtFirstNo.Text);
            int num2 = Convert.ToInt32(TxtSecondNo.Text);
            int result = num1 + num2;
            Response.Write(result);
            TxtResult.Text = Convert.ToString(result);
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            int num1 = Convert.ToInt32(TxtFirstNo.Text);
            int num2 = Convert.ToInt32(TxtSecondNo.Text);
            int result = num1 - num2;
            TxtResult.Text = Convert.ToString(result);
        }

        protected void Button3_Click(object sender, EventArgs e)
        {
            int num1 = Convert.ToInt32(TxtFirstNo.Text);
            int num2 = Convert.ToInt32(TxtSecondNo.Text);
            int result = num1 * num2;
            TxtResult.Text = Convert.ToString(result);
        }

        protected void Button4_Click(object sender, EventArgs e)
        {
            int num1 = Convert.ToInt32(TxtFirstNo.Text);
            int num2 = Convert.ToInt32(TxtSecondNo.Text);
            int result = num1 / num2;
            TxtResult.Text = Convert.ToString(result);
        }
    }
}