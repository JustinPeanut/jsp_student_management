<%@ page import="com.peanut.bean.Student" %>
<%@ page import="com.peanut.utils.constant.Constant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="http://localhost:8080/JSP_Student_manage_war_exploded/">
    <link href="css/base.css" rel="stylesheet"/>
    <link href="css/home.css" rel="stylesheet"/>
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
            if(student == null){
        %>
        <li>
            <span>登录</span>
        </li>
        <%
            }else{
        %>
        <li>
            <span><%=student.getSname()%></span>
        </li>

        <%
            }
        %>
        <li id="quit">
            <span>退出</span>
        </li>
    </div>

    <script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/quit.js"></script>
</div>
</body>
</html>

