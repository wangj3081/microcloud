package com.microcloud;

import java.sql.*;

/**
 * @Auther: wangjian
 */
public class TestMain {

    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver").newInstance();
        String url = "jdbc:postgresql://192.168.158.134:5432/demo";
        Connection connection = DriverManager.getConnection(url, "postgresql", "123");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from city");
        ResultSetMetaData metaData = resultSet.getMetaData();
        if (resultSet != null) {
            while (resultSet.next()) {
                for (int i = 1; i < metaData.getColumnCount(); i++) {
                    System.out.println(resultSet.getString(i)+":" + resultSet.getString(2));
                }
            }
        }

    }
}
