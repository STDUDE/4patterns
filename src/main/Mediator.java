package main;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Mediator {
    private DatabaseSupport db = new DatabaseSupport();
    private DataWriter writer = new DataWriter();

    public void setectEmployees(ArrayList employees){
        db.connect();
        ResultSet res = db.selectFrom("SELECT * FROM employee WHERE task = -1");
        writer.write(res, employees);
        db.closeConnect();
    }
}
