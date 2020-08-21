package com.kittycoder;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by shucheng on 2020/7/15 12:58
 * 获取单个数据库连接
 */
public class MyTest {

    private static final String JDBC_URL = "jdbc:h2:mem://localhost/~/spitter";
    private static final String USER = "sa";
    public static final String PASSWORD = "";
    public static final String DRIVER_CLASS = "org.h2.Driver";

    public static void main(String[] args) throws Exception {
        Class.forName(DRIVER_CLASS);
        Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        System.out.println(connection);
        connection.close();
    }
}
