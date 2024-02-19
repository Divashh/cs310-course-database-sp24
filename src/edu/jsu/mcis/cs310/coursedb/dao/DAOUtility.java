package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {
    
    public static final int TERMID_FA24 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {
            //Get Metadata     
            ResultSetMetaData rmd = rs.getMetaData();
            
            //Use the iteration in the resultset
            while (rs.next()){
                JsonObject row = new JsonObject(); //This is one record
                for(int i=1; i<=rmd.getColumnCount(); i++){
                    String ColumnName = rmd.getColumnName(i);
                    String ColumnValue = rs.getString(ColumnName);
                    row.put(ColumnName, ColumnValue);
                    
                }
                //Adding the row to the Json array.
                records.add(row);
                
                
            }

            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}
