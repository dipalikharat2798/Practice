<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Elogin.aspx.cs" Inherits="Ecommerce.Elogin" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            text-decoration: underline;
            text-align: center;
            font-size: xx-large;
            color: #FF0000;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div class="auto-style1">
            <strong style="background-color: #66FFFF">Elogin</strong></div>
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" style="font-weight: 700; text-align: center" Text="Login" />
    </form>
</body>
</html>
