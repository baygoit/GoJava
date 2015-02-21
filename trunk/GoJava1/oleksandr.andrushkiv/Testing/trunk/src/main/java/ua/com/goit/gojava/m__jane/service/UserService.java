package ua.com.goit.gojava.m__jane.service;
import ua.com.goit.gojava.m__jane.model.User;

public interface UserService {

	User checkUser(String login, String password);
}
