package com.peanut.dao;

import com.peanut.utils.connection.MyConnection;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDao<T> {

    private Class<T> clazz;

    {
        // 初始化子类实现的接口的泛型类型
        // 这里使用接口（父类）也可以
        Type genericSuperclass = this.getClass().getGenericInterfaces()[0];
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

    // 插入通用的方法
    public void insert(String sql,Connection connection,String... args) {
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement(sql);
            for(int i = 0 ; i < args.length ; i++){
                ps.setObject(i+1,args[i]);
            }
            ps.execute();
            System.out.println("插入成功！");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 考虑到有事务，该连接最好不要关闭
            MyConnection.close(connection,ps,null);
        }
    }

    // 更新通用的方法
    public void update(String sql,Connection connection,String... args){
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement(sql);
            for(int i = 0 ; i < args.length ; i++){
                ps.setObject(i+1,args[i]);
            }
            ps.execute();
            System.out.println("更新成功！");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 考虑到有事务，该连接最好不要关闭
            MyConnection.close(connection,ps,null);
        }
    }

    // 删除通用的方法
    public void delete(String sql,Connection connection,String... args){
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement(sql);
            for(int i = 0 ; i < args.length ; i++){
                ps.setObject(i+1,args[i]);
            }
            ps.execute();
            System.out.println("更新成功！");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 考虑到有事务，该连接最好不要关闭
            MyConnection.close(connection,ps,null);
        }
    }

    // 查询单个通用的方法
    public T select(String sql ,Connection connection,String... args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData rsm = null;
        try{
            ps = connection.prepareStatement(sql);
            for(int i = 0 ; i < args.length ; i++){
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            // 获取字段的个数
            int columnCount = rsm.getColumnCount();
            T instance = (T)clazz.getDeclaredConstructor().newInstance();
            while(rs.next()){
                for(int i = 0 ; i < columnCount ; i++){
                    String columnLabel = rsm.getColumnLabel(i + 1);
                    Object object = rs.getObject(i + 1);
                    Field filed = clazz.getDeclaredField(columnLabel);
                    filed.setAccessible(true);
                    filed.set(instance,object);
                }
                return instance;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyConnection.close(connection,ps,rs);
        }
        return null;
    }

    public List<T> selectAll(String sql ,Connection connection){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData rsm = null;
        List<T> list = new ArrayList<>();
        try{
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            // 获取字段的个数
            int columnCount = rsm.getColumnCount();
            while(rs.next()){
                T instance = (T)clazz.getDeclaredConstructor().newInstance();
                for(int i = 0 ; i < columnCount ; i++){
                    String columnLabel = rsm.getColumnLabel(i + 1);
                    Object object = rs.getObject(i + 1);
                    Field filed = clazz.getDeclaredField(columnLabel);
                    filed.setAccessible(true);
                    filed.set(instance,object);
                }
                list.add(instance);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyConnection.close(connection,ps,rs);
        }
        return null;
    }

}
