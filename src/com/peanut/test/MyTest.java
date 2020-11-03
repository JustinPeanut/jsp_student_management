package com.peanut.test;

import com.peanut.bean.Student;
import com.peanut.dao.StudentDaoImpl;
import com.peanut.utils.connection.MyConnection;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyTest {
    @Test
    public void testProperties() throws Exception {
        MyConnection myConnection = new MyConnection();
        Connection connection = myConnection.getConnection();
        List<Student> list = new ArrayList<>();
        // 预编译sql语句
        PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
        // 执行sql语句
        ResultSet resultSet = preparedStatement.executeQuery();
        // 获取元数据
        ResultSetMetaData metaData = resultSet.getMetaData();
        // 有多少列
        Student student = new Student();
        int columnCount = metaData.getColumnCount();
        while(resultSet.next()){
            for(int i = 0 ; i < columnCount ; i++){
                // 将结果映射到类上面
                String columnLabel = metaData.getColumnLabel(i+1);
                Field field = Student.class.getDeclaredField(columnLabel);
                field.setAccessible(true);
                field.set(student,resultSet.getObject(i + 1));
                list.add(student);
            }
        }
        System.out.println(list);
    }

    @Test
    public void testClass() throws Exception {
        MyConnection myConnection = new MyConnection();
        Connection connection = myConnection.getConnection();
        StudentDaoImpl impl = new StudentDaoImpl();
        impl.insert(connection,"zz","男","21","1","郑州");
    }

    @Test
    public void testSelectAll() throws Exception{
        MyConnection myConnection = new MyConnection();
        Connection connection = myConnection.getConnection();
        StudentDaoImpl impl = new StudentDaoImpl();
        List<Student> list = impl.selectAll(connection);
        System.out.println(list);

    }
}
