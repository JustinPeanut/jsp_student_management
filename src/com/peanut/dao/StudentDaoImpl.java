package com.peanut.dao;

import com.peanut.bean.Student;
import com.peanut.utils.exception.NoSuchStudent;

import java.sql.Connection;
import java.util.List;

public class StudentDaoImpl extends BaseDao<Student> implements StudentDao<Student> {
    @Override
    public void insert(Connection connection,String... args) throws Exception {
        String sql = "insert into student(Sname,Ssex,Sage,SdeptId,city) values(?,?,?,?,?)";
        insert(sql,connection,args);
    }

    @Override
    public List<Student> selectAll(Connection connection) {
        String sql = "select * from student";
        List<Student> list = selectAll(sql, connection);
        return list;
    }

    @Override
    public void deleteBySno(Connection connection,String... args) {
        String sql = "delete from student where Sno = ?";
        delete(sql,connection,args);
    }

    @Override
    public void updateBySno(Connection connection,String... args) {
        String sql = "";
    }

    @Override
    public Student selectByUsername(Connection connection, String... args) {
        Student student = null;
        try{
            String sql = "select * from student where Sname = ?";
            List<Student> students = select(sql, connection, args);
            if(students == null || students.size() == 0){
                throw new NoSuchStudent("学生不存在");
            }
            student  = students.get(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }
}
