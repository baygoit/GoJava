package ua.com.goit.gojava.m__jane.service;
import java.util.List;
import java.util.Map;

import ua.com.goit.gojava.m__jane.model.Profile;
import ua.com.goit.gojava.m__jane.model.Quiz;
import ua.com.goit.gojava.m__jane.model.User;

public interface UserService {

	User checkUser(String login, String password);
	Map<Profile, List<Quiz>> getUserDetailsMap(User user);
}
