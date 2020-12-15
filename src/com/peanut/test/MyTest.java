package com.peanut.test;

import com.peanut.bean.Course;
import com.peanut.bean.Student;
import com.peanut.dao.CourseDao;
import com.peanut.dao.CourseDaoImpl;
import com.peanut.dao.StudentDaoImpl;
import com.peanut.utils.connection.MyConnection;
import com.peanut.utils.util.ObjectToJson;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyTest {
    private Connection  connection = null;

    @Before
    public void init() throws Exception {
        connection = MyConnection.getConnection();
    }

    @Test
    public void testConnection() throws Exception {
        Connection connection = MyConnection.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testSelect() throws Exception {
        MyConnection myConnection = new MyConnection();
        Connection connection = MyConnection.getConnection();
        List<Student> list = new ArrayList<>();
        // 预编译sql语句
        PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
        // 执行sql语句
        ResultSet resultSet = preparedStatement.executeQuery();
        // 获取元数据
        ResultSetMetaData metaData = resultSet.getMetaData();
        // 有多少列

        int columnCount = metaData.getColumnCount();
        while(resultSet.next()){
            Student student = new Student();
            for(int i = 0 ; i < columnCount ; i++){
                // 将结果映射到类上面
                String columnLabel = metaData.getColumnLabel(i+1);
                Field field = Student.class.getDeclaredField(columnLabel);
                field.setAccessible(true);
                field.set(student,resultSet.getObject(i + 1));

            }
            list.add(student);
        }
        System.out.println(list);
    }

    @Test
    public void testClass() throws Exception {
        Connection connection = MyConnection.getConnection();
        StudentDaoImpl impl = new StudentDaoImpl();
        impl.insert(connection,"zz","男","21","1","郑州");
    }

    @Test
    public void testSelectAll() throws Exception{
        MyConnection myConnection = new MyConnection();
        Connection connection = MyConnection.getConnection();
        StudentDaoImpl impl = new StudentDaoImpl();
        List<Student> list = impl.selectAll(connection);
        System.out.println(list);

    }

    @Test
    public void testSelectCourse() throws Exception {
        Connection connection = MyConnection.getConnection();
        CourseDaoImpl courseDao = new CourseDaoImpl();
        List<Course> courses = courseDao.selectAll(connection);
        System.out.println(courses);
    }

    @Test
    public void testSelectCourseStudent() throws Exception {
        Connection connection = MyConnection.getConnection();
        CourseDaoImpl courseDao = new CourseDaoImpl();
        List<Course> courses = courseDao.selectStudentSelect(connection,"1");
        System.out.println(courses);
    }

    @Test
    public void testJson() throws Exception {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        List<Course> list = courseDao.selectAll(connection);
        String s = ObjectToJson.toJson(list);
        System.out.println(s);
    }

    @Test
    public void testAdd() throws Exception {
        StudentDaoImpl courseDao = new StudentDaoImpl();

        Boolean aBoolean = courseDao.addCourseByStudent(MyConnection.getConnection(), "1", "5");
        System.out.println(aBoolean);
    }
}

