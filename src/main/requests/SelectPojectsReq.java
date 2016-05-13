package main.requests;

import main.dbconnect.DBConnect;
import main.model.Project;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Antony on 13.05.2016.
 */
public class SelectPojectsReq implements IRequest{
    DBConnect dbConnect;

    Connection dbConnection = null;
    Statement statement = null;
    ResultSet result = null;

    public SelectPojectsReq(){
        dbConnect = new DBConnect();
    }

    @Override
    public void GenerateRequest() {
        String requestTableSQL = "SELECT * FROM `reports`.project ;";
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

        ArrayList<Project> projects = new ArrayList<>();

        while (result.next()) {
            projects.add(new Project(result.getInt("id"),
                    result.getString("name"),
                    result.getDate("begin"),
                    result.getDate("deadline")));
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
