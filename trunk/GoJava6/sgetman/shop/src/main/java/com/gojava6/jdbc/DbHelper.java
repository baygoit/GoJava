package com.gojava6.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by sergiigetman on 10/7/15.
 */
public class DbHelper {

    public static final String DBMS = "h2";

    public static void main(String[] args) {
        DbHelper dbHelper = new DbHelper();
        dbHelper.createAndPopulateDatabase(DBMS);
    }


    private void createAndPopulateDatabase(String dbms) {
        Connection conn = null;
        Statement stmt = null;

        Properties properties = new Properties();

        try{
            loadProperties(dbms, properties);

            Class.forName(properties.getProperty("jdbc.driver"));

            System.out.println("Connecting to dbms...");
            conn = DriverManager.getConnection(properties.getProperty("db.url"),
                    properties.getProperty("user"),
                    properties.getProperty("pass"));

            stmt = conn.createStatement();

            createDatabase(stmt, dbms);

            populateDatabase(stmt, dbms);

            conn.close();

        } catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }

    private void populateDatabase(Statement stmt, String database) throws SQLException {
        executeInsertQuery(stmt, database + "/insertUsers.sql", "User table populated");
        executeInsertQuery(stmt, database + "/insertRooms.sql", "Room table populated");
        executeInsertQuery(stmt, database + "/insertReservations.sql", "Reservation table populated");
    }

    private void createDatabase(Statement stmt, String database) throws SQLException {
        System.out.println("Creating database...");

        /*executeCreateQuery(stmt, database + "/createAirbnb.sql", "Database");
        if("mysql".equals(database)) {
            executeCreateQuery(stmt, database + "/useAirbnb.sql", "Database");
        }*/
        executeCreateQuery(stmt, database + "/createUser.sql", "User table");
        executeCreateQuery(stmt, database + "/createRoom.sql", "Room table");
        executeCreateQuery(stmt, database + "/createReservation.sql", "Reservation table");
    }

    private void loadProperties(String database, Properties properties) {
        try {
            properties.load(DbHelper.class.getClassLoader().
                    getResourceAsStream("config/" + database + ".properties" ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private  String executeCreateQuery(Statement stmt, String filename, String x) throws SQLException {
        String createUser = getStatement(filename);
        stmt.executeUpdate(createUser);
        System.out.println(x + " created successfully...");
        return createUser;
    }

    private void executeInsertQuery(Statement stmt, String filename, String x) throws SQLException {
        String queries = getStatement(filename);
        String[] inserts = queries.split(System.getProperty("line.separator"));
        for (String insert : inserts) {
            if(!insert.isEmpty())
                stmt.executeUpdate(insert);
        }

        System.out.println(x + " successfully...");
    }

    private String getStatement(String filename) {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(
                    new InputStreamReader(
                    DbHelper.class.getClassLoader().
                            getResourceAsStream("sql/" + filename), "UTF-8"));
            String string = null;
            while ((string = bufferedReader.readLine()) != null) {
                sb.append(System.getProperty("line.separator")).append(string);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }


}
