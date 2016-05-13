package main.requests;

import main.dbconnect.DBConnect;
import main.model.Task;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Antony on 13.05.2016.
 */
public class SelectTasksReq implements IRequest{
    DBConnect dbConnect;

    Connection dbConnection = null;
    Statement statement = null;
    ResultSet result = null;

    public SelectTasksReq(){
        dbConnect = new DBConnect();
    }

    @Override
    public void GenerateRequest() {
        String requestTableSQL = "SELECT * FROM `reports`.task ;";
        dbConnection = dbConnect.getConnection();
        try {
            statement = dbConnection.createStatement();
            result = statement.executeQuery(requestTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList GetResponse() throws SQLException {

        ResultSetMetaData resultMD = result.getMetaData();
        int colCount = resultMD.getColumnCount();

        ArrayList<Task> tasks = new ArrayList<>();

        while (result.next()) {
            tasks.add(new Task(result.getInt("id"),
                    result.getString("content"),
                    result.getInt("id_project"),
                    result.getDate("deadline"),
                    result.getBoolean("status")));
        }

        if(dbConnection != null)
            dbConnection.close();
        if(statement != null)
            statement.close();
        if(result != null)
            result.close();
        return tasks;
    }
}
