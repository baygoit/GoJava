package ua.nenya.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.nenya.dao.UserDao;
import ua.nenya.project.User;
import ua.nenya.util.ConnectionManager;

public class UserDaoDbImpl implements UserDao{
	
	private ConnectionManager connectionManager;
	private List<User> users = new ArrayList<>();

	public UserDaoDbImpl(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	@Override
	public void initUsers() {
		String query = "SELECT * FROM users";
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet set = statement.executeQuery(query);
			while(set.next()){
				User user = new User(set.getString("login"), set.getString("password"), set.getString("email"));
				if(user != null){
					users.add(user);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getUsers() {
		return users;
	}

}
