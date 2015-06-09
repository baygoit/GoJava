package web.kickstarter.databaseDao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseService {

	Connection getConnection();

	void closeConnection() throws SQLException;

	void createConnection() throws SQLException;

}
