<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="EHome.aspx.cs" Inherits="Ecommerce.EHome" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            text-decoration: underline;
        }
        .auto-style2 {
            text-align: center;
            color: #FF0066;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div class="auto-style1">
            <h1 class="auto-style2"><strong>EHome</strong></h1>
        </div>
        <p style="text-align: center">
            &nbsp;</p>
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Click to return login" />
    </form>
</body>
</html>
