package com.zhangeaky.ee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo {

    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhangeaky",
                "root", "a1234567");

        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("select * from user where age = ?");
        preparedStatement.setString(1, "10");
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println(resultSet);
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            System.out.println(name);
        }


        int name = resultSet.findColumn("id");
        System.out.println("id: " + name);


    }
}
