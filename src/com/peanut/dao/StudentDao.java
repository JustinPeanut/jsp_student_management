package com.peanut.dao;

import java.sql.Connection;
import java.util.List;

public interface StudentDao<T> {

    void insert(Connection connection,String... args) throws Exception;

    List<T> selectAll(Connection connection);

    void deleteBySno(Connection connection,String... args);

    void updateBySno(Connection connection,String... args);

    T selectByUsername(Connection connection,String... args) throws Exception;

    Boolean addCourseByStudent(Connection connection,String... args);

    Long courseCount(Connection connection,String sql,String... args);

}
