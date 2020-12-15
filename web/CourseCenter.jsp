<%@ page import="com.peanut.bean.Student" %>
<%@ page import="com.peanut.utils.constant.Constant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="http://localhost:8080/JSP_Student_manage_war_exploded/">
    <link href="css/base.css" rel="stylesheet"/>
    <link href="css/home.css" rel="stylesheet"/>
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet"/>
    <script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/courseGenerate.js"></script>
    <style type="text/css">
        .mt{
            margin-top: 100px;
        }
        a{
            color: #0f0f0f;
        }
        a:hover{
            text-decoration: none;
        }
        a:active{
            text-decoration: none;
        }
    </style>
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
        <li>
            <div class="btn-group ">
                <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    点我 <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a id="return-home" href="home">返回主页</a></li>
                    <li><a href="ownCourse">查看我的选课</a></li>
                </ul>
            </div>
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
        <li id="quit" onclick="(function quit() {
           window.location.href = 'http://localhost:8080/JSP_Student_manage_war_exploded/login';
        })()">
            <span>退出</span>
        </li>
    </div>
</div>
<div class="course-center">

    <table class="table table-striped">
        <thead>
            <td>#</td>
            <td>选课名称</td>
            <td>教室名称</td>
            <td>上课时间</td>
            <td>操作</td>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>1</td>
                <td>1</td>
                <td>1</td>
                <td>1</td>
            </tr>
            <tr>
                <td>1</td>
                <td>1</td>
                <td>1</td>
                <td>1</td>
                <td>1</td>
            </tr>
        </tbody>
    </table>

    <script type="text/javascript">
        let list = <%=session.getAttribute(Constant.ATTR_ALL_COURSE)%>;

        let table = $(".table");

        generate(list,table,"选课","success","add");

    </script>

</div>
</body>
</html>

