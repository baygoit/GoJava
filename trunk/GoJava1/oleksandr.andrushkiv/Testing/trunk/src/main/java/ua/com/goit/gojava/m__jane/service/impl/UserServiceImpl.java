package ua.com.goit.gojava.m__jane.service.impl;

import java.util.List;

import javax.xml.bind.JAXBException;

import ua.com.goit.gojava.m__jane.exceptions.TestingServiceException;
import ua.com.goit.gojava.m__jane.model.User;
import ua.com.goit.gojava.m__jane.service.UserService;
import ua.com.goit.gojava.m__jane.utils.DataBuilder;

public class UserServiceImpl implements UserService {

	private List<User> userList;

	public UserServiceImpl() throws TestingServiceException {
		loadProfileList();
	}

	private void loadProfileList() throws TestingServiceException {

		try {
			userList = DataBuilder.getInstance().getDataLoader().getUserList();
		} catch (JAXBException e) {
			throw new TestingServiceException("Can't load data!");
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

}
