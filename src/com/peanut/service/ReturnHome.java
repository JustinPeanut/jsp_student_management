package com.peanut.service;

import com.peanut.bean.Course;
import com.peanut.bean.Student;
import com.peanut.dao.CourseDaoImpl;
import com.peanut.utils.connection.MyConnection;
import com.peanut.utils.constant.Constant;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class ReturnHome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            HttpSession session = req.getSession();
            Student student = (Student) session.getAttribute(Constant.ATTR_STUDENT);
            //并且查询出学生的选课信息
            CourseDaoImpl courseDao = new CourseDaoImpl();

            Connection connection1 = MyConnection.getConnection();

            List<Course> courses = courseDao.selectStudentSelect(connection1, student.getSno()+"");

            // 设置回session
            JSONArray jsonArray = JSONArray.fromCollection(courses);

            String courseJson = jsonArray.toString();

            session.setAttribute(Constant.ATTR_STUDENT_COURSES,courseJson);

            req.getRequestDispatcher("WEB-INF/student/home.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
