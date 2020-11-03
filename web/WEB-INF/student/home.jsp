<%@ page import="com.peanut.utils.constant.Constant" %>
<%@ page import="com.peanut.bean.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<base href="http://localhost:8080/JSP_Student_manage_war_exploded/">
<link href="css/base.css" rel="stylesheet"/>
<style type="text/css">
    .title-bar{
        display: flex;
        height: 70px;
        width: 100%;
        background-color: #2aabd2;
        line-height: 70px;
        color: #fff;
        font-family: 幼圆;

    }
    #right li:hover{
        background-color: #1b6d85;
    }

    #imgTitle{
        width: 600px;
        display: flex;
    }
    .title-bar li{
        flex: 1;
        list-style: none;
        text-align: center;
    }
    #right{
        width: 150px;
        display: flex;
    }
    #middleText{
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
            <li>
                <span id="quit">退出</span>
            </li>
        </div>
</div>

<script type="text/javascript">
    let elementById = document.getElementById("quit");

    elementById.onclick = function () {

        window.location.href = "http://localhost:8080/JSP_Student_manage_war_exploded/login";

    }
</script>
</body>
</html>

