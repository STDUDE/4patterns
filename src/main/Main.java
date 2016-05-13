package main;

import java.sql.SQLException;

/**
 * Created by Antony on 13.05.2016.
 */
public class Main {
    public static void main(String ...args){
        try {
            Work.runConsol();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
