package com.km.colegio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mariadb://localhost:3308/Colegio";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed");
        }
        return connection;
    }

    public static void main(String[] args) {
        // Test the connection
        getConnection();
    }
}
