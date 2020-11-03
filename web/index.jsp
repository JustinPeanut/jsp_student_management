<%@ page import="com.peanut.utils.constant.Constant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="http://localhost:8080/JSP_Student_manage_war_exploded/">
    <link href="bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet"/>
    <style type="text/css">
        .login{
            position: relative;
            margin: 100px auto;
            width: 400px;
            text-align: center;
        }
        .login input,button{
            border-radius: 8%;
            margin: 5px;
        }
        .title{
            margin: 50px auto;
            text-align: center;
            color: #2aabd2;
            font-weight: bold;
            font-size: 20px;
        }
        .red-exception{
            color: red;
            text-align: center;
        }
    </style>
</head>

<body style="background-image: url('img/bg.jpg');background-repeat: no-repeat;">
    <div class="title">江西理工大学525学生选课系统</div>
    <div class="login">
        <form action="login" method="post">
            <%
                String loginException = (String) session.getAttribute(Constant.ATTR_LOGIN_EXCEPTION);

                if(loginException != null){
            %>

            <p class="red-exception">
                <%=loginException%>
            </p>

            <%
            }
            %>

            <%
                String exception = (String) session.getAttribute(Constant.ATTR_EXCEPTION);

                if(exception != null){
            %>

            <p class="red-exception">
                <%=exception%>
            </p>

            <%
                }
            %>
            <span style="color: #fff">请输入姓名：</span><input type="text" name="username"/><br/>
            <span style="color: #fff">请输入密码：</span><input type="password" name="password"/><br/>
            <button class="btn-success" type="submit">登陆</button>
            <button class="btn-warning" type="button">注册</button>
        </form>
    </div>
    <a href="test"></a>
<script type="text/javascript">

</script>
</body>
</html>

