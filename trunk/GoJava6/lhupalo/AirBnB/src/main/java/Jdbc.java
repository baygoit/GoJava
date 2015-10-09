import javax.management.PersistentMBean;
import java.sql.*;

/**
 * Created by Ыўср on 07.10.2015.
 */
public class Jdbc {
    private String url = "jdbc:mysql://localhost:3306/AIRBNB";
    private String name = "root";
    private String pass = "1234";
    private Connection connection = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String sql = null;

    public void getConnection() {
        try {
            connection = DriverManager.getConnection(url, name, pass);
            stmt = connection.createStatement();
            System.out.println( "Connect");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void close(){
        try {
            stmt.close();
            connection.close();
           // rs.close();
            System.out.println("Connect closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
