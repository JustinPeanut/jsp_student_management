package com.peanut.service;

import com.peanut.bean.Course;
import com.peanut.dao.CourseDaoImpl;
import com.peanut.utils.connection.MyConnection;
import com.peanut.utils.constant.Constant;
import com.peanut.utils.util.ObjectToJson;
import com.sun.org.apache.bcel.internal.Const;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class ToCourseCenter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // 在执行跳转之前，在数据库中查询相关的信息
        Connection connection = null;
        HttpSession session = null;
        try{
            // 获取连接
            connection = MyConnection.getConnection();

            CourseDaoImpl courseDao = new CourseDaoImpl();

            List<Course> list = courseDao.selectAll(connection);

            String result = ObjectToJson.toJson(list);
            // 如果数据查询成功，将list设置到session中
            session = req.getSession();

            session.setAttribute(Constant.ATTR_ALL_COURSE,result);

            // 重定向到CourseCenter.jsp
            resp.sendRedirect("http://localhost:8080/JSP_Student_manage_war_exploded/CourseCenter.jsp");

        }catch (Exception e){

            e.printStackTrace();
            // 这里可以自定义一些异常消息返回前端的页面
        }finally {

            MyConnection.close(connection,null,null);

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req,resp);
    }
}
