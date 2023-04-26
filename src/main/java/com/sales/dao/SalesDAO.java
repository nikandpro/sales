package com.sales.dao;

import java.sql.*;

public class SalesDAO {

    public static void main(String[] args) throws ClassNotFoundException {
    Connection conn = null;
    PreparedStatement myStmt = null;

    String url = "jdbc:mysql://127.0.0.1:3306/bd_1";
    String user = "root";
    String pas = "";

    Class.forName("com.mysql.cj.jdbc.Driver");
    try (Connection connection = DriverManager.getConnection(url,user,pas);
         Statement statement = connection.createStatement()) {
        System.out.println("Connect");
        ResultSet resultSet = statement.executeQuery("select * from sales");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getInt(2));
            System.out.println(resultSet.getDate(3));
            System.out.println(resultSet.getDate(4));
            System.out.println("-------------------------");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    }


}
