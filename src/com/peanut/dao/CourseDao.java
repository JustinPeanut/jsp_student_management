package com.peanut.dao;

import java.sql.Connection;
import java.util.List;

public interface CourseDao<T> {
    List<T> selectAll(Connection connection, String... args);
    List<T> selectStudentSelect(Connection connection,String... args);
    void deleteCourseByStudent(Connection connection,String... args);
}
