package web.kickstarter.databaseDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseServiceImpl implements DatabaseService {
	Connection connection;
	@Override
	public void createConnection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kickstarter",
				"postgres", "root");
	}

	@Override
	public Connection getConnection() {
		return connection;
	}
    @Override
    public void closeConnection() throws SQLException {
            connection.close();
            
    }
}
