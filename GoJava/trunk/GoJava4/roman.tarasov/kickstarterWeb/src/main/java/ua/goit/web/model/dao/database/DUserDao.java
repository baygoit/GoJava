package ua.goit.web.model.dao.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ua.goit.web.model.dao.Comment;
import ua.goit.web.model.dao.KickstarterException;
import ua.goit.web.model.dao.User;


public class DUserDao  {
	private Connection conn;

	public User getUserInfo(String login, String password)
			throws KickstarterException {
		Statement statement;
		User user = null;

		try {
			conn = Pool.getDataSource().getConnection();
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
		}
		if (user == null) {
			throw new KickstarterException("user not found");
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

	public List<String> getUsersNamesByListComments(
			List<Comment> comments) throws KickstarterException {
		Statement statement;
		List<String> usersNames = new ArrayList<String>();

		try {
			conn = Pool.getDataSource().getConnection();
			for (Comment currentComment : comments) {

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
		}
		if (usersNames == null) {
			throw new KickstarterException("users not found");
		}
		return usersNames;
	}
}