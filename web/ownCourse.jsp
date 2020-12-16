<%@ page import="com.peanut.bean.Student" %>
<%@ page import="com.peanut.utils.constant.Constant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="http://localhost:8080/JSP_Student_manage_war_exploded/">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet"/>
    <link href="css/base.css" rel="stylesheet"/>
    <link href="css/home.css" rel="stylesheet"/>
    <script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/courseGenerate.js"></script>
</head>


<body>
<div class="title-bar">
    <div id="imgTitle">
        <li>
            <img height="70px" src="img/江西理工大学.png"/>
        </li>
        <li>
            <span>525学生选课系统</span>
        </li>
    </div>
    <div id="middleText">

    </div>
    <div id="right">
        <%
            // 获取传递过来的student信息
            Student student = (Student) session.getAttribute(Constant.ATTR_STUDENT);
        %>
        <li>
            <span><%=student.getSname()%></span>
        </li>
        <li id="quit" onclick="(function quit() {
           window.location.href = 'http://localhost:8080/JSP_Student_manage_war_exploded/login';
        })()">
            <span>退出</span>
        </li>
    </div>
</div>
<%%>
<div class="info-body">
    <%
        String exception = (String) session.getAttribute(Constant.ATTR_EXCEPTION);
        String success = (String)session.getAttribute(Constant.ATTR_ADD_R_INFO);
        exception = exception == null ? "": exception;
        success = success == null ? "": success;
    %>
    <div style="text-align: center">
        <p>
            <%=exception%><%=success%>
        </p>
    </div>

    <%--取消本次选课传递的信息--%>
    <%

        session.setAttribute(Constant.ATTR_EXCEPTION,null);
        session.setAttribute(Constant.ATTR_ADD_R_INFO,null);
    %>
    <div style="margin: 100px auto;text-align: center">
        <button class="btn-lg btn-success">
            <a href="http://localhost:8080/JSP_Student_manage_war_exploded/to/course/center">点击此处继续选课</a>
        </button>
    </div>
</div>

</body>
</html>

