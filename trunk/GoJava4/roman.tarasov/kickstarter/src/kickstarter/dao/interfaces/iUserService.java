package kickstarter.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import kickstarter.entity.CurrentUserStatus;
import kickstarter.entity.User;

public interface iUserService {
	CurrentUserStatus verifyAccount(String login, String password) throws SQLException;
	
	void createAccounts(iDAO sourceDAO) throws SQLException;
	List<User> getAll();

	CurrentUserStatus getUserStatus();
}
