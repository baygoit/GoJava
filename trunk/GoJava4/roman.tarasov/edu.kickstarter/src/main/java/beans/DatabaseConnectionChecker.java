package beans;

import java.sql.Connection;
import java.sql.SQLException;

import dao.pool.KickstarterException;
import dao.pool.Pool;

public abstract class DatabaseConnectionChecker {
	boolean connected() {
		boolean connected = false;
		try {
			Connection conn = Pool.getInstance().getConnection();
			conn.close();
			connected = true;
		} catch (KickstarterException | SQLException e) {

		}
		return connected;
	}
}
