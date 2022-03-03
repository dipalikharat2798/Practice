<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="CalculationHome.aspx.cs" Inherits="CALculationWeb.CalculationHome" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            text-align: center;
        }
        .auto-style2 {
            color: #FF0066;
            text-decoration: underline;
        }
        .auto-style3 {
            width: 168px;
        }
        .auto-style4 {
            width: 183px;
        }
        .auto-style5 {
            width: 168px;
            height: 26px;
        }
        .auto-style6 {
            width: 183px;
            height: 26px;
        }
        .auto-style7 {
            height: 26px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div class="auto-style1">

            <h1 class="auto-style2"><strong>Calculation</strong></h1>

        </div>
        <table style="width:100%;">
            <tr>
                <td class="auto-style5">First Number</td>
                <td class="auto-style6">
                    <asp:TextBox ID="TxtFirstNo" runat="server" OnTextChanged="TextBox1_TextChanged"></asp:TextBox>
                </td>
                <td class="auto-style7">Result :
                    <asp:TextBox ID="TxtResult" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style3">Second Number</td>
                <td class="auto-style4">
                    <asp:TextBox ID="TxtSecondNo" runat="server"></asp:TextBox>
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td class="auto-style3">
                    <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Button" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:Button ID="Button2" runat="server" OnClick="Button2_Click" Text="Button" />
                </td>
                <td class="auto-style4">
                    <asp:Button ID="Button3" runat="server" OnClick="Button3_Click" Text="Button" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:Button ID="Button4" runat="server" OnClick="Button4_Click" Text="Button" />
                </td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </form>
</body>
</html>
