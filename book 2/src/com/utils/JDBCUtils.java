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
import java.util.Properties;

//数据库连接的工具类
public class JDBCUtils {
    //创建数据库连接池
    private static DataSource dataSource;
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
    public static Connection getConnection() throws Exception {
        Connection connection = dataSource.getConnection();
       return connection;
    }
    //关闭资源
    public static void close(Connection connection){
        DbUtils.closeQuietly(connection);
    }
    //测试连接和关闭
    @Test
    public void testConnection() throws Exception {
        Connection connection = getConnection();
        System.out.println(connection);
        close(connection);
        System.out.println(connection);
    }
}
