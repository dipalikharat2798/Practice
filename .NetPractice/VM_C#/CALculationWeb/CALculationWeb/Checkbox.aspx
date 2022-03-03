<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Checkbox.aspx.cs" Inherits="CALculationWeb.Checkbox" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:CheckBox ID="CheckBox1" runat="server" Text="C#" /><br />
            <asp:CheckBox ID="CheckBox2" runat="server" Text="Java" /><br />
            <asp:CheckBox ID="CheckBox3" runat="server" Text="HTML" /><br />
            <asp:CheckBox ID="CheckBox4" runat="server" Text="JS" />
            <br />
            <br />
            <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Button" />
&nbsp;&nbsp;&nbsp;
            <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
            <br />
        </div>
    &nbsp;</form>
</body>
</html>
