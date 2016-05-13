package main.requests;

import main.dbconnect.DBConnect;
import main.model.Employee;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Antony on 13.05.2016.
 */
public class SelectEmployeesReq implements IRequest{
    DBConnect dbConnect;

    Connection dbConnection = null;
    Statement statement = null;
    ResultSet result = null;

    public SelectEmployeesReq(){
        dbConnect = new DBConnect();
    }

    @Override
    public void GenerateRequest() {
        String requestTableSQL = "SELECT * FROM `reports`.employee ;";
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

        ArrayList<Employee> projects = new ArrayList<>();

        while (result.next()) {
            projects.add(new Employee(result.getInt("id"),
                    result.getString("fname"),
                    result.getString("lname"),
                    result.getString("post"),
                    result.getInt("task")));
        }

        if(dbConnection != null)
            dbConnection.close();
        if(statement != null)
            statement.close();
        if(result != null)
            result.close();
        return projects;
    }
}
