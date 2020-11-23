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

public class RemoveCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        Connection connection1 = null;
        try{
            // 获取参数
            String courseId = req.getParameter("courseId");

            HttpSession session = req.getSession();

            Student student = (Student) session.getAttribute(Constant.ATTR_STUDENT);

            Integer sno = student.getSno();

            CourseDaoImpl impl = new CourseDaoImpl();
            // 获取连接
            connection = MyConnection.getConnection();
            // 执行删除
            impl.deleteCourseByStudent(connection,courseId,sno+"");
            // 如果删除成功，返回页面

            connection1 = MyConnection.getConnection();
            CourseDaoImpl courseDao = new CourseDaoImpl();

            List<Course> courses = courseDao.selectStudentSelect(connection1, student.getSno()+"");

            // 设置回session
            JSONArray jsonArray = JSONArray.fromCollection(courses);

            String courseJson = jsonArray.toString();

            session.setAttribute(Constant.ATTR_STUDENT_COURSES,courseJson);

        }catch (Exception e){
            // 如果有异常,简单的打印
            e.printStackTrace();
        }finally {
            MyConnection.close(null,null,null);
            req.getRequestDispatcher("WEB-INF/student/home.jsp").forward(req,resp);
        }

    }
}
