package main;

import java.sql.SQLException;

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
