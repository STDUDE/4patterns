package main;

import users.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataWriter {
    public void write(ResultSet res, ArrayList employees){
        try {
            int i = 1;
            while(res.next()){
                System.out.println(i + ") " + res.getString("fname"));
                employees.add(new User(res.getString("fname"), res.getString("lname"), res.getString("post"), -1, null));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
