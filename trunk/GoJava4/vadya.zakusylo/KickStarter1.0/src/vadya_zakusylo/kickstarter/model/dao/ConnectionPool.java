package vadya_zakusylo.kickstarter.model.dao;

import java.sql.Connection;

public interface ConnectionPool {

	Connection getConnection();

	void closeConnection(Connection connection);

}
