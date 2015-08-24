package goit.nz.kickstarter.storage;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataStorage {

	Connection getConnection() throws SQLException;

	void init(String propertyFile);

}
