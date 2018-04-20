<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>

<head>
    <title>登录页面</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
        $(function () {
            $('#pl').dialog({
                iconCls: 'images/spacer.gif',
                width: 400,
                height: 150,
                title: '登陆',
                closable: false
            });

            $("#login_btn").click(function () {
                alert("---------login_btn-----------");
                var flag = false;
                var userName = $("#userName").val();
                alert(userName);
                if (!userName.length > 0) {
                    flag = true;
                    $("#userIdSpan").html("<font color='red'>用户代码不能为空</font>");
                }
                var pwd = $("#password").val();
                alert(pwd);
                if (!pwd.length > 0) {
                    flag = true;
                    $("#passwordSpan").html("<font color='red'>密码不能为空</font>");
                }
                if (!flag) {
                    $("#loginForm").submit();
                }
            });
        });

        function loadimage() {
            document.getElementById("randImage").src = "images/image.jsp?"
                + Math.random();
        }

        /* 	function submitForm() {
                var flag = false;
                if (trim(loginForm.userName.value).length == 0) {
                    flag = true;
                    document.getElementById("userIdSpan").innerHTML = "<font color='red'>用户代码不能为空</font>";
                }
                if (trim(loginForm.password.value).length == 0) {
                    flag = true;
                    document.getElementById("passwordSpan").innerHTML = "<font color='red'>密码不能为空</font>";
                }
                if (!flag) {
                    loginForm.action = "login.jsp";
                    loginForm.method = "post";
                    loginForm.submit();
                }
            } */
    </script>
</head>

<body>
<div id="pan" style="width: 100%; height: 100%; margin: 0 auto;">
    <div id="pl">
        <form action="${pageContext.request.contextPath}/login.action"
              id="loginForm" method="post">
            <table style="margin: auto auto;">
                <TR>
                    <TD align="left"><FONT
                            face="verdana, arial, helvetica, sans-serif" size="-1">用户名:&nbsp;</FONT>
                    </TD>
                    <TD align="left"><INPUT type="text" name="userName"
                                            id="userName" size="20" maxlength="20"> <span
                            id="userIdSpan"></span></TD>
                </TR>
                <TR>
                    <TD align="left"><FONT
                            face="verdana, arial, helvetica, sans-serif" size="-1">密&nbsp&nbsp&nbsp码:</FONT>
                    </TD>
                    <TD align="left"><INPUT name="password" id="password"
                                            type="password" size="21" maxlength="20"><span
                            id="passwordSpan"></span></TD>
                </TR>
                <tr>
                    <td><input type="checkbox" name="rememberMe"/></td>
                    <TD><input type="submit" id="login_btn" value="登陆"/></TD>

                </tr>
            </table>
        </form>
    </div>
</div>
</body>

</html>