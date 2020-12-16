package com.peanut.service;

import com.peanut.bean.Student;
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

public class AddCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Student student = (Student) session.getAttribute(Constant.ATTR_STUDENT);
        Integer sno = student.getSno();
        String courseId = req.getParameter("courseId");
        System.out.println(sno +"  " + courseId);
        Connection connection = null;
        StudentDaoImpl dao = new StudentDaoImpl();
        try{
            connection = MyConnection.getConnection();
            Boolean flag = dao.addCourseByStudent(connection, sno + "", courseId);
            if(!flag){
                session.setAttribute(Constant.ATTR_EXCEPTION,"选课失败！选课最多四门，或者你已经选过该门课程！");
            }else{
                session.setAttribute(Constant.ATTR_ADD_R_INFO,"选课成功！");
            }
        }catch (Exception e){
            session.setAttribute(Constant.ATTR_EXCEPTION,e.getMessage());
        }

        resp.sendRedirect("http://localhost:8080/JSP_Student_manage_war_exploded/ownCourse.jsp");
    }
}
