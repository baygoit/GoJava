package ua.dborisenko.kickstarter;

import java.sql.SQLException;

public class AppStarter {

    public static void main(String[] args) throws SQLException {
        Kickstarter kickstarter = new Kickstarter();
        kickstarter.run();
    }
}
