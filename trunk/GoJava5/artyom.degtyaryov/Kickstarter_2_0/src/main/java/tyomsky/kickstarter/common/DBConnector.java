package tyomsky.kickstarter.common;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {

    private Properties properties;
    private String dbms;
    private String driver;
    private String host;
    private String port;
    private String dbName;
    private String userName;
    private String password;

    public DBConnector(String propertiesFileName) {
        setProperties(propertiesFileName);
    }

    public Connection getConnection () {
        Connection connection = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);

        if ("h2".equals(this.dbms)) {
            String currentUrlString = "jdbc:" + this.dbms + ":" + this.host + ":" + this.dbName;
            try {
                Class.forName(driver);
                connection =
                        DriverManager.getConnection(currentUrlString + ";DB_CLOSE_DELAY=-1",
                                connectionProps);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    private void setProperties(String fileName) {
        properties = new Properties();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        try (FileInputStream fis = new FileInputStream(file)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dbms = properties.getProperty("dbms");
        driver = properties.getProperty("driver");
        host = properties.getProperty("host");
        port = properties.getProperty("port");
        dbName = properties.getProperty("database_name");
        this.userName = properties.getProperty("user_name");
        this.password = properties.getProperty("password");
    }

}
