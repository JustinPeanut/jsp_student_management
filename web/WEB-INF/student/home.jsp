<%@ page import="com.peanut.utils.constant.Constant" %>
<%@ page import="com.peanut.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.peanut.bean.Course" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<base href="http://localhost:8080/JSP_Student_manage_war_exploded/">
<link href="css/base.css" rel="stylesheet"/>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet"/>
<style type="text/css">
    .title-bar {
        display: flex;
        height: 70px;
        width: 100%;
        background-color: #2aabd2;
        line-height: 70px;
        color: #fff;
        font-family: 幼圆;

    }

    #right li:hover {
        background-color: #1b6d85;
    }

    #imgTitle {
        width: 600px;
        display: flex;
    }

    .title-bar li {
        flex: 1;
        list-style: none;
        text-align: center;
    }

    #right {
        width: 150px;
        display: flex;
    }

    #middleText {
        flex: 1;
    }

    .caption h3, p, a {
        font-size: 15px;
        margin-left: 30px;
    }

    .left-info {
        margin-top: 10px;
        margin-left: 25px;
        position: relative;
        float: left;
        width: 370px;
    }

    .course {
        width: 500px;
        height: 395px;
        margin-top: 10px;
        position: relative;
        float: left;
        margin-left: 25px;
        margin-right: 10px;
    }

    .student-course {
        padding: 20px;
        text-align: center;
        line-height: 100%;
    }

    .right-info {
        width: 420px;
        height: 396px;
        position: relative;
        margin-right: 30px;
        margin-top: 10px;
        align-items: center;
    }

    .borderc {
        border-radius: 25px;
        border: 1px solid #9d9d9d;
    }

    .right-info ul {
        display: flex;
        padding: 10px;
        list-style: none;
        text-align: center;

    }

    .right-info ul li {
        flex: 1;
    }
    .right-info a{
        text-decoration: none;
        font-size: 10px;
    }
    .Mycontent{
        display: flex;
    }

    .course{
        flex: 1;
    }


</style>

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
        <li id="quit">
            <span>退出</span>
        </li>
    </div>
</div>

<div class="Mycontent">
    <div class="left-info content">
        <div class="row">

            <div class="thumbnail">
                <img src="img/xs_bg.jpg" alt="...">
                <div class="caption">
                    <h3>学生信息:</h3>
                    <p>姓名：<%=student.getSname()%>
                    </p>
                    <p>年龄：<%=student.getSage()%>
                    </p>
                    <p>性别：<%=student.getSsex()%>
                    </p>
                    <p>城市：<%=student.getCity()%>
                    </p>
                    <a href="javascript:;" class="btn btn-primary" role="button">修改</a>
                </div>
            </div>
        </div>
    </div>

    <div class="course row borderc content">
        <div class="student-course">
            <table class="table table-hover">
                <tr>
                    <td>#</td>
                    <td>我的选课</td>
                    <td>教室名称</td>
                    <td>上课时间</td>
                    <td>操作</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>数据结构</td>
                    <td>xxx</td>
                    <td>xxx</td>
                    <td>
                        <button type="button" class="btn-xs btn-danger">删除</button>
                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>计算机网络</td>
                    <td>xxx</td>
                    <td>xxx</td>
                    <td>
                        <button type="button" class="btn-xs btn-danger">删除</button>
                    </td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>JSP程序设计</td>
                    <td>xxx</td>
                    <td>xxx</td>
                    <td>
                        <button type="button" class="btn-xs btn-danger">删除</button>
                    </td>
                </tr>
            </table>
        </div>
    </div>

    <div class="right-info borderc content">
        <ul>
            <li>
                <a href="javascript:;">
                    <div>
                        <img src="img/tb9.png"/>
                    </div>
                    <span>学生选课中心</span>
                </a>
            </li>
            <li>
                <a href="javascript:;">
                    <div>
                        <img src="img/tb11.png"/>
                    </div>

                    <span>课程成绩查询</span>
                </a>
            </li>
            <li>
                <a href="javascript:;">
                    <div>
                        <img src="img/tb12.png"/>
                    </div>
                    <span>培养方法明细</span>
                </a>
            </li>
            <li>
                <a href="javascript:;">
                    <div>
                        <img src="img/tb14.png"/>
                    </div>
                    <span>考试安排查询</span>
                </a>
            </li>
        </ul>

    </div>
</div>

<div>
    <%
        String list = (String) session.getAttribute(Constant.ATTR_STUDENT_COURSES);
        if(list == null){

    %>
    <%
        }

    %>
</div>

<script type="text/javascript">
    // 获取已经选的课
    let list = <%=session.getAttribute(Constant.ATTR_STUDENT_COURSES)%>;

    console.log(list)

    let elementById = document.getElementById("quit");

    elementById.onclick = function () {

        window.location.href = "http://localhost:8080/JSP_Student_manage_war_exploded/login";

    }
</script>
</body>
</html>

