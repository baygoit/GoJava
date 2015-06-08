package kickstarter.dao.databaseServices;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import kickstarter.dao.interfaces.iDAO;
import kickstarter.dao.interfaces.iUserService;
import kickstarter.entity.CurrentUserStatus;
import kickstarter.entity.User;

public class DBUserService implements iUserService {
	private CurrentUserStatus userStatus = null;
	private iDatabaseService databaseService;

	public DBUserService(iDatabaseService databaseService) {
		this.databaseService = databaseService;
	}

	@Override
	public List<User> getAll() {
		return null;
	}

	@Override
	public void createAccounts(iDAO sourceDAO) throws SQLException {
		List<User> users = sourceDAO.getUserService().getAll();
		StringBuffer sql = new StringBuffer();

		Statement statement = databaseService.getConnection().createStatement();
		statement.executeUpdate("DROP TABLE IF EXISTS  users ");
		statement
				.executeUpdate("CREATE TABLE users (id SERIAL not null PRIMARY KEY, login varchar(255),password varchar(255),name varchar(255)) ");
		for (User user : users) {
			sql.append("INSERT INTO ");
			sql.append("users ");
			sql.append("VALUES ");
			sql.append("(");
			sql.append(user.getID());
			sql.append(",'");
			sql.append(user.getLogin());
			sql.append("','");
			sql.append(user.getPassword());
			sql.append("','");
			sql.append(user.getName());
			sql.append("')");
			statement.executeUpdate(sql.toString());
		}
	}

	@Override
	public CurrentUserStatus verifyAccount(String login, String password)
			throws SQLException {
		StringBuffer sql = new StringBuffer();

		Statement statement = databaseService.getConnection().createStatement();
		sql.append("SELECT ");
		sql.append(" * ");
		sql.append("FROM ");
		sql.append("users ");
		sql.append("WHERE ");
		sql.append("login='");
		sql.append(login);
		sql.append("' AND ");
		sql.append("password='");
		sql.append(password);
		sql.append("'");
		statement.executeQuery(sql.toString());
		ResultSet rs = statement.getResultSet();
		rs.next();
		userStatus = new CurrentUserStatus();
		userStatus.setName(rs.getString("name"));
		userStatus.setID(rs.getInt("id"));
		return userStatus;
	}

	@Override
	public CurrentUserStatus getUserStatus() {
		return userStatus;
	}
}
