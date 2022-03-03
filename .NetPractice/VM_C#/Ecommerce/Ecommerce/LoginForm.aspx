<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="LoginForm.aspx.cs" Inherits="Ecommerce.LoginForm" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            text-align: center;
        }
        .newStyle1 {
            background-color: #00FFFF;
        }
        .auto-style2 {
            width: 113px;
        }
        .newStyle2 {
            line-height: normal;
        }
        .newStyle3 {
            background-color: #66FFFF;
            border-style: double;
            border-width: 3px;
        }
        .newStyle4 {
            background-color: #66FFFF;
            border-style: double;
        }
        .newStyle5 {
            background-color: #FF00FF;
        }
        .newStyle6 {
            background-color: #FF00FF;
        }
        .auto-style3 {
            background-color: #FF00FF;
            color: #FF0066;
        }
        .newStyle7 {
            background-color: #FF00FF;
        }
    </style>
</head>
<body style="height: 178px">
    <form id="form1" runat="server">
        <div class="auto-style1">
            <h1 class="newStyle2"><span class="auto-style3" style="text-align: center; background-color: #66FFFF"><strong>Elogin</strong></span></h1>
        </div>
        <table style="width:100%;">
            <tr>
                <td class="auto-style2"><span class="newStyle3">Enter User Name</span></td>
                <td>
                    <asp:TextBox ID="TxtUserName" runat="server"></asp:TextBox>
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td class="auto-style2">
                    <asp:Label ID="Label1" runat="server" CssClass="newStyle4" Text="Password"></asp:Label>
                </td>
                <td>
                    <asp:TextBox ID="TxtPassword" runat="server"></asp:TextBox>
                </td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td class="auto-style2">
                    <asp:Button ID="ButLogin" runat="server" CssClass="newStyle7" OnClick="ButLogin_Click" Text="Login" />
                </td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </form>
</body>
</html>
