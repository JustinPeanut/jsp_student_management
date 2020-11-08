package com.peanut.service;

import com.peanut.bean.Course;
import com.peanut.bean.Student;
import com.peanut.dao.CourseDaoImpl;
import com.peanut.dao.StudentDaoImpl;
import com.peanut.utils.connection.MyConnection;
import com.peanut.utils.constant.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;


public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = null;
        // 获取数据库连接
        try {
            req.setCharacterEncoding("UTF-8");

            String username = req.getParameter("username");

            String password = req.getParameter("password");

            Connection connection = MyConnection.getConnection();

            StudentDaoImpl studentDao = new StudentDaoImpl();

            // 查询学生验证登录
            Student student = studentDao.selectByUsername(connection,username);


            session = req.getSession();

            if(student != null && password.equals(student.getSpassword())){
                // 如果密码正确，就返回页面
                session.setAttribute(Constant.ATTR_STUDENT,student);

                //并且查询出学生的选课信息
                CourseDaoImpl courseDao = new CourseDaoImpl();

                List<Course> courses = courseDao.selectStudentSelect(connection, student.getSno().toString());

                // 设置回session
                session.setAttribute(Constant.ATTR_STUDENT_COURSES,courses);

                req.getRequestDispatcher("WEB-INF/student/home.jsp").forward(req,resp);

            }else{
                // 如果密码错误，或者用户名没有查到，返回
                session.setAttribute(Constant.ATTR_LOGIN_EXCEPTION, Constant.LOGIN_FAILED);

                resp.sendRedirect("http://localhost:8080/JSP_Student_manage_war_exploded/");
            }

        } catch (Exception e) {
            e.printStackTrace();
            // 如果产生异常,返回错误信息
            session.setAttribute(Constant.ATTR_EXCEPTION,e.getMessage());

            resp.sendRedirect("http://localhost:8080/JSP_Student_manage_war_exploded/");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 注销登陆信息
        HttpSession session = req.getSession();

        session.invalidate();

        resp.sendRedirect("http://localhost:8080/JSP_Student_manage_war_exploded/");
    }
}
