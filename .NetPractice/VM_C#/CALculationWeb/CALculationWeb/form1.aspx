<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="form1.aspx.cs" Inherits="CALculationWeb.form1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:ListBox ID="ListBox1" runat="server" AutoPostBack="True" OnSelectedIndexChanged="ListBox1_SelectedIndexChanged">
                <asp:ListItem Value="C#"></asp:ListItem>
                <asp:ListItem Value="Java"></asp:ListItem>
                <asp:ListItem Value="Html"></asp:ListItem>
            </asp:ListBox>
&nbsp;&nbsp;&nbsp;
        </div>
        <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
        <p>
            &nbsp;</p>
        <asp:ListBox ID="LstBooks" runat="server" AutoPostBack="True" OnSelectedIndexChanged="ListBox2_SelectedIndexChanged"></asp:ListBox>
        <br />
        <asp:Label ID="Label2" runat="server" Text="Label"></asp:Label>
    </form>
</body>
</html>
