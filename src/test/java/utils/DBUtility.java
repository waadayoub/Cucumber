package utils;

import org.apache.commons.math3.linear.ConjugateGradient;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {
    private static ResultSet rset;
    private static ResultSetMetaData rSetMetaData;
    static Connection conn = null;
    static Statement statement = null;
    /**
     * This method create connection to the database, execute query and return object ResulSet
     *
     * @param sqlQuery
     * @return ResultSet
     */
    public static ResultSet getResultSet(String sqlQuery) {


        try {
            //establish conection with the DB
            conn = DriverManager.getConnection(
                    ConfigReader.getPropertyValue("dburl"),
                    ConfigReader.getPropertyValue("dbusername"),
                    ConfigReader.getPropertyValue("dbpassword"));
            //create a statement to execute query
            statement = conn.createStatement();
//execute the query and store the results
            rset = statement.executeQuery(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        } /*finally {

            try {
                if (statement != null) {
                    statement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        return rset;
    }

    /**
     * This method return an Object of ResultSetMetaData
     *
     * @param query
     * @return ResultSetMetaData
     */
    public static ResultSetMetaData getRsetMetada(String query) {
        rset = getResultSet(query);
        rSetMetaData = null;
        try {
            //we use the code below to get the data in tabular format
            // So we could use them in column keys and values retrieval operation
            rSetMetaData = rset.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rSetMetaData;
    }

    /**
     * This method extract data from ResultSet and stores into List of Maps
     */

    public static List<Map<String, String>> getListOfMapsFromRset(String query) {

        rSetMetaData = getRsetMetada(query);
        List<Map<String, String>> listFromRset = new ArrayList<>();
        Map<String, String> mapData;

        try {
            //iterates over rows
            while (rset.next()) {
                mapData = new LinkedHashMap<>();
//iterates over the columns
                for (int i = 1; i <= rSetMetaData.getColumnCount(); i++) {
                    String key = rSetMetaData.getColumnName(i);
                    //will return the value against the key
                    String value = rset.getString(key);
                    //store data from every column into the map
                    mapData.put(key, value);
                }
                //we store the maps with data into the list
                listFromRset.add(mapData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtility.closeResultSet(rset);
            DBUtility.closeStatement(statement);
            DBUtility.closeConnection(conn);
        }
        return listFromRset;
    }

    public static void closeResultSet(ResultSet rset) {
        if (rset != null) {
            try {
                rset.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
