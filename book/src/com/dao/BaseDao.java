package com.dao;

import com.pojo.Customer;
import com.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    //创建DBUtils工具类QueryRunner
    QueryRunner queryRunner = new QueryRunner();

    /**
     * 用于增删改的通用操作
     *
     * @param sql  执行的sql语句
     * @param args 传入的参数
     * @return 返回受影响的行数
     */
    public int update(String sql, Object... args) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            int updateCount = queryRunner.update(conn, sql, args);
            return updateCount;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
        return -1;
    }

    /**
     * 用于查询单个记录
     *
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args 传入的参数
     * @param <T>  返回类型的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            T query = queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
            return query;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
        return null;
    }

    /**
     * 以列表的形式返回多个记录
     *
     * @param type 返回的类型
     * @param sql  执行的sql语句
     * @param args 传入的参数
     * @param <T>  返回类型的参数
     * @return 以列表的形式返回多个参数
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            List<T> query = queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
            return query;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }return null;

    }

    public Object queryForSingleValue(String sql, Object... args) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Object query = queryRunner.query(conn, sql, new ScalarHandler(), args);
            return query;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
        return null;
    }
    //以下测试都是在没有改为抽象类的时候测试,实在test数据库进行测试的,都测试成功了
//    //测试update
//    @Test
//    public void testUpdate(){
//        int i = update("insert into customers (name,email,birth) values(?,?,?)", "日常", "richang@qq.com", "2001-2-23");
//        System.out.println(i);
//    }
//    //测试queryForOne
//    @Test
//    public void testQuery(){
//        Customer customer = queryForOne(Customer.class, "select id,name,email,birth from customers where id = ?", 16);
//        System.out.println(customer);
//    }
//    @Test
//    public void testQuery2(){
//        List<Customer> customers = queryForList(Customer.class, "select id,name,email,birth from customers where id > ?", 16);
//        customers.forEach(System.out::println);
//    }
//    @Test
//    public void testQuery3(){
//        Object o = queryForSingleValue("select count(*) from customers");
//        System.out.println(o);
//    }
}
