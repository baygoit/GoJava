package kickstarter.dao.defaultServices;

import java.util.ArrayList;
import java.util.List;

import kickstarter.dao.interfaces.iDAO;
import kickstarter.dao.interfaces.iUserService;
import kickstarter.entity.CurrentUserStatus;
import kickstarter.entity.User;

public class DefaultUserService implements iUserService {
	private List<User> users;
	private CurrentUserStatus userStatus=null;
	public DefaultUserService(){
		users=new ArrayList<User>();
		User user=new User();
		user.setID(5);
		user.setLogin("user");
		user.setPassword("guest");
		user.setName("anonymous");
		users.add(user);
	}
	@Override
	public List<User> getAll() {
		return users;
	}


	@Override
	public void createAccounts(iDAO sourceDAO) {
		// TODO Auto-generated method stub

	}
	@Override
	public CurrentUserStatus verifyAccount(String login, String password) {
		for(User currentUser:users){
			if(currentUser.getLogin().equals(login)&&currentUser.getPassword().equals(password)){
				userStatus=new CurrentUserStatus();
				userStatus.setID(currentUser.getID());
				userStatus.setName(currentUser.getName());
				return userStatus;
			}
		}
		return null;
	}
	@Override
	public CurrentUserStatus getUserStatus() {
	
		return userStatus;
	}

}
