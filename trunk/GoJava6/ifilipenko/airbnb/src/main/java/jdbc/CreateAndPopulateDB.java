package jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CreateAndPopulateDB{
    private static final String url;
    private static final String username;
    private static final String password;

    static {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("src/main/resources/database.properties"))) {
            props.load(in);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            Class.forName(props.getProperty("jdbc.drivers"));
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        url         = props.getProperty("jdbc.url");
        username    = props.getProperty("jdbc.username");
        password    = props.getProperty("jdbc.password");
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

}
