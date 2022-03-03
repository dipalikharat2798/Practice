<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="CALculationWeb.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:RadioButton ID="RadioButton1" runat="server" GroupName="tech" Text="c#" /><br />
            <asp:RadioButton ID="RadioButton2" runat="server" GroupName="tech" Text="java" /><br />
            <asp:RadioButton ID="RadioButton3" runat="server" GroupName="tech" OnCheckedChanged="RadioButton3_CheckedChanged" Text="html" /><br />
            <br />
            <asp:RadioButton ID="RadioButton4" runat="server" /><br />
            <asp:RadioButton ID="RadioButton5" runat="server" /><br />
            <asp:RadioButton ID="RadioButton6" runat="server" /><br />
            <br />
            <br />
        </div>
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Button" />
        <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
        <br />
        <br />
        <br />
    </form>
</body>
</html>
