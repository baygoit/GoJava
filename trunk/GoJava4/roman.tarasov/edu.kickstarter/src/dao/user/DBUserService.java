package dao.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dao.pool.KickstarterException;

public class DBUserService implements UserService {
	private Connection conn;

	public DBUserService(Connection conn) {
		this.conn = conn;
	}

	@Override
	public User getUserInfo(String login, String password)
			throws KickstarterException {
		Statement statement;
		User user = null;
		try {
			statement = conn.createStatement();
			StringBuffer sql = new StringBuffer();
			sql.append("select ");
			sql.append("login , ");
			sql.append("password , ");
			sql.append("name ");
			sql.append("from ");
			sql.append("users ");
			sql.append("where ");
			sql.append("login='");
			sql.append(login);
			sql.append("' and ");
			sql.append("password='");
			sql.append(password);
			sql.append("'");
			ResultSet rs = statement.executeQuery(sql.toString());
			rs.next();
			if (!rs.wasNull()) {
				user = new User();
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setLogin(rs.getString("login"));
			}
		} catch (SQLException e) {
			user = null;
			throw new KickstarterException("query error", e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (user == null) {
				throw new KickstarterException("user not found");
			}
		}
		return user;
	}
}