package ua.com.goit.gojava.m__jane.service.implXML;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import ua.com.goit.gojava.m__jane.exceptions.TestingServiceException;
import ua.com.goit.gojava.m__jane.model.Profile;
import ua.com.goit.gojava.m__jane.model.Quiz;
import ua.com.goit.gojava.m__jane.model.User;
import ua.com.goit.gojava.m__jane.service.UserService;
import ua.com.goit.gojava.m__jane.utils.DataBuilder;

public class UserServiceImplXML implements UserService {

	private List<User> userList;

	public UserServiceImplXML() throws TestingServiceException {
		loadProfileList();
	}

	private void loadProfileList() throws TestingServiceException {

		try {
			userList = DataBuilder.getInstance().getDataLoader().getUserList();
		} catch (JAXBException e) {
			throw new TestingServiceException("Can't load data from xml file!");
		}
	}

	@Override
	public User checkUser(String login, String password) {

		for (User user : userList) {
			if (user.getLogin().equals(login)&& user.getPassword().equals(password)) {
				return user;
			}
		}
		
		return null;
	}

	@Override
	public Map<Profile, List<Quiz>> getUserDetailsMap(User user) {
		Map<Profile, List<Quiz>> userDetails = new HashMap<>();
		for (Profile profile : user.getProfileList()) {
			userDetails.put(profile, profile.getQuizList());					
		}
				
		return userDetails;
	}

}
