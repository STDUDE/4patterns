package main.requests;

import main.dbconnect.DBConnect;
import main.model.Task;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Antony on 13.05.2016.
 */
public class SelectTasksByPrjReq extends SelectTasksReq {
    int project_id = 1;

    @Override
    public void GenerateRequest() {
        String project_id = String.valueOf(this.project_id);
        String requestTableSQL = "SELECT * FROM `reports`.task WHERE project_id = " + project_id + ";";
        dbConnection = dbConnect.getConnection();
        try {
            statement = dbConnection.createStatement();
            result = statement.executeQuery(requestTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
}
