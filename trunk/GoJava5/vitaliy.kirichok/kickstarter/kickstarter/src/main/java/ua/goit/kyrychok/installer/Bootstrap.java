package ua.goit.kyrychok.installer;

import java.sql.SQLException;

public class Bootstrap {

    public static final String SERVER = "localhost";
    public static final int PORT = 5432;
    public static final String USER_ADMIN = "postgres";
    public static final String PASSWORD_ADMIN = "123456";
    public static final String DB_NAME = "kickstarter";
    public static final String USER = "kickstarter";
    public static final String PASSWORD = "123456";

    public static void main(String[] args) {
        InstallerOutput output = new ConsoleInstallerOutput();
        //Create Database
        PostgreSQLProvider adminConnection = new PostgreSQLProvider(output);
        try {
            adminConnection.init(SERVER, PORT, USER_ADMIN, PASSWORD_ADMIN);
            adminConnection.testConnection();
            StepDatabase stepDatabase = new StepDatabase(output, adminConnection);
            stepDatabase.createDatabase(DB_NAME, USER);
        } catch (SQLException e) {
            throw new RuntimeException("Something wrong", e);
        } finally {
            adminConnection.close();//TODO Check if not open
        }
        //Create DDL
        PostgreSQLProvider userConnection = new PostgreSQLProvider(output);
        try {
            userConnection.init(SERVER, PORT, DB_NAME, USER, PASSWORD);
            userConnection.testConnection();
            StepDdlUpdator ddlUpdator = new StepDdlUpdator(output, userConnection);
            ddlUpdator.update();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            userConnection.close();//TODO Check if not open
        }
    }
}
