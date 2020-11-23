package com.peanut.dao;

import com.peanut.bean.Course;

import java.sql.Connection;
import java.util.List;

public class CourseDaoImpl extends BaseDao<Course> implements CourseDao<Course> {
    @Override
    public List<Course> selectAll(Connection connection, String... args) {
        String sql = "select * from course";
        return selectAll(sql,connection);
    }

    @Override
    public List<Course> selectStudentSelect(Connection connection, String... args) {
        String sql = "select * from course where courseId in (select courseId from sc where Sno = ?)";
        return select(sql,connection,args);
    }

    @Override
    public void deleteCourseByStudent(Connection connection, String... args) {
        String sql = "delete from sc where courseId = ? and Sno = ?";
        delete(sql,connection,args);
    }


}
