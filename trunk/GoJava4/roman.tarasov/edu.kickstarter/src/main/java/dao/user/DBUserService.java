package dao.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dao.comments.ProjectComment;
import dao.pool.KickstarterException;
import dao.pool.Pool;

public class DBUserService implements UserService {
	private Connection conn;

	@Override
	public User getUserInfo(String login, String password)
			throws KickstarterException {
		Statement statement;
		User user = null;

		try {
			conn = Pool.getInstance().getConnection();
			statement = conn.createStatement();
			StringBuffer sql = new StringBuffer();
			sql.append("select ");
			sql.append("id , ");
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
				user.setID(rs.getInt("id"));
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

	private String getUserNameByID(Integer userID, Statement statement)
			throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		sql.append("name ");
		sql.append("from ");
		sql.append("users ");
		sql.append("where ");
		sql.append("id=");
		sql.append(Integer.toString(userID));

		ResultSet rs = statement.executeQuery(sql.toString());
		rs.next();
		if (!rs.wasNull()) {
			return rs.getString("name");
		}
		return null;
	}

	@Override
	public List<String> getUsersNamesByListComments(
			List<ProjectComment> comments) throws KickstarterException {
		Statement statement;
		List<String> usersNames = new ArrayList<String>();

		try {
			conn = Pool.getInstance().getConnection();
			for (ProjectComment currentComment : comments) {

				statement = conn.createStatement();
				String name = null;
				try {
					name = getUserNameByID(currentComment.getUserID(),
							statement);
				} catch (SQLException e) {
				}
				usersNames.add(name);
			}
		} catch (SQLException e) {
			usersNames = null;

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (usersNames == null) {
				throw new KickstarterException("users not found");
			}
		}
		return usersNames;
	}
}