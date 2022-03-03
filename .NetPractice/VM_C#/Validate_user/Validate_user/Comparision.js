< !DOCTYPE html >
    <html>
        <head>
            <meta charset="utf-8" />
            <title></title>
            <script>
                function validate() {
    var name = document.reg.sname.value;
    var mob = document.reg.mob.value;
    var age = document.getElementById("Text3").value;
    var age = document.reg.age.value;

    var rname = new RegExp("^[a-zA-Z]{6, 10}$");
    var rmob = new RegExp("^[987][0-9]{9}$");
    var rage = new RegExp("^[0-9]{1, 2}$");

    if (rname.test(name) == false) {
    var inputVal = document.getElementsByID("subEmail");
    inputVal.style.backgroundColor = "yellow";
    alert("name should be min 6 and max 10 characters and start with alphabet");
    return false;
    }
    if (rmob.test(mob) == false) {
                    alert("invalid mobile number");
    return false;
    }
    if (rage.test(age) == false) {
                    alert("Invalid age");
    return false;
    }
    return true;

        }
        function checkFilled() {
            if (rmob.test(mob) == false) {
            var inputVal = document.getElementById("Text1");
            if (inputVal.value == "") {
                    inputVal.style.border = "yellow";
                alert("name should be min 6 and max 10 characters and start with alphabet");
                return false;
            }
                if (rmob.test(mob) == false) {
                    inputVal.style.border = "yellow";
                alert("invalid mobile number");
                return false;
            }
                if (rage.test(age) == false) {
                    inputVal.style.border = "yellow";
                alert("Invalid age");
                return false;
            }
            return true;
        }
</script>
        </head>
        <body>
            <form id="form1" name="reg" runat="server">

                <span class="style1">STUDENT REGISTRATION FORM </span> <br />
                <p>
                    Enter Name :
            <input id="Text1" type="text" placeholder="Name" name="sname" onchange="checkFilled();" /> <br />
                </p>
                <p>
                    Mobile :
            <input id="Text2" type="text" placeholder="Mobile" name="mob" onchange="checkFilled();" /> <br />
                </p>
                <p>
                    Enter Age:
            <input id="Text3" type="text" placeholder="Age" name="age" onchange="checkFilled();" /> <br />
                </p>
                <input id="Submit1" type="submit" value="submit" onclick="return validate();" />
            </form>
        </body>
    </html>