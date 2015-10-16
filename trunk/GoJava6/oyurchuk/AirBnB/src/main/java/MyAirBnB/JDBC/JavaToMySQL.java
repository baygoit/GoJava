package MyAirBnB.JDBC;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by macmini on 11.10.15.
 */
public class JavaToMySQL {

    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "";



    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main (String args []){
    String query = "select count(*) from user";

        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()){
                int count = rs.getInt(1);
                System.out.print("Total numbers of user in the table: " + count);
            }

        } catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }

        finally {
            try { con.close(); } catch (SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch (SQLException se) {/*can't do anything */ }
            try { rs.close(); } catch (SQLException se) {/*can't do anything */ }

           }


        }

    }




