package main.requests;

import org.json.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Antony on 12.11.2015.
 */
public interface IRequest {
    public void GenerateRequest();
    public ArrayList GetResponse() throws SQLException;
}
