package main.dbconnect;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Antony on 13.05.2016.
 */
public class DBConnect {
    private static String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static String DB_CONNECTION = "jdbc:mysql://localhost:3306/reports";
    private static String DB_USER = "root";
    private static String DB_PASSWORD = "123123";

    public Connection getConnection() {
        Connection dbConnection = null;
        dbConnection = getDBConnection();
        return dbConnection;
    }

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return dbConnection;
    }
}
