package main;
import java.sql.*;

public class DatabaseSupport {
    private Connection conn;
    private Statement statement;
    private char [][][]symbol;
    public DatabaseSupport(){
        conn = null;
        statement = null;
    }
    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is JDBC Driver?");
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reports", "root", "root");
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean insertInTo(String insertStr){
        try {
            statement.executeUpdate(insertStr);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ResultSet selectFrom(String selStr){
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(selStr);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rs;
    }
    public boolean updateAndDelete(String execute){
        try {
            statement.execute(execute);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void closeConnect(){
        try {
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}