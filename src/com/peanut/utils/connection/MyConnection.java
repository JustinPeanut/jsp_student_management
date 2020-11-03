package com.peanut.utils.connection;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class MyConnection {

    private static Properties loadProperties(String fileName) throws IOException {
        // 读取配置文件
        InputStream resourceAsStream = MyConnection.class.
                getClassLoader().
                getResourceAsStream(fileName);
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        return properties;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {

        Properties properties = loadProperties("mysql/mysqlConnection.properties");
        String url = properties.getProperty("url");
        String password = properties.getProperty("password");
        String username = properties.getProperty("username");
        String driverClass = properties.getProperty("driverClass");

        // 加载驱动
        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }

    public static void close(Connection connection, PreparedStatement ps, ResultSet rs) {
        if(connection != null){
            try{
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ps != null){
            try{
                ps.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(rs != null){
            try{
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }




}
