package com.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

//数据库连接的工具类
public class JDBCUtils {
    //创建数据库连接池
    private static DataSource dataSource;
    //给线程绑定一个connection用于事务管理
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();
    static {
        //这里记得不能使用ClassLoader.getClassLoader().get....
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
            dataSource = new DruidDataSourceFactory().createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获得连接

    /**
     *
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        Connection connection = dataSource.getConnection();
//        try {
//            //将获取到的连接保存到ThreadLocal对象中,供后面jdbc使用
//            conns.set(connection);
//            //将事务管理设置为手动
//            connection.setAutoCommit(false);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return connection;
    }
    //关闭资源
    public static void close(Connection connection){
        DbUtils.closeQuietly(connection);
    }

    /**
     * 提交事务并且关闭数据库连接(connection)
     */
    public static void commitAndClose(){
        //从线程中获取连接对象
        Connection connection = conns.get();
        //判断线程中是否有连接对象
        if (connection != null) {
            //将事务提交
            try {
                connection.commit();
            }catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    //关闭数据库连接
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //将线程移除，否则会出错，因为tomcat服务器底层使用了线程池技术
        conns.remove();
    }
    /**
     * 回滚事务并且关闭数据库连接(connection)
     */
    public static void rollbackAndClose(){
        //从线程中获取连接对象
        Connection connection = conns.get();
        //判断线程中是否有连接对象
        if (connection != null) {
            //将事务提交
            try {
                connection.rollback();
            }catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    //关闭数据库连接
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //将线程移除，否则会出错，因为tomcat服务器底层使用了线程池技术
        conns.remove();
    }
    //测试连接和关闭
    @Test
    public void testConnection() throws Exception {
        Connection connection = getConnection();
        System.out.println(connection);
//        close(connection);
        System.out.println(connection);
    }
}
