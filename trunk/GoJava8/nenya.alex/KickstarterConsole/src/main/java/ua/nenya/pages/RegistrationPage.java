package ua.nenya.pages;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ua.nenya.main.KickstarterInitilizer;
import ua.nenya.project.User;
import ua.nenya.util.IO;

public class RegistrationPage {
	private static final String USERS_FILE_NAME = "src/main/resources/users.json";

	public User registration(KickstarterInitilizer initilizer, IO io) {
		List<User> users = initilizer.getUserDao().getUsers();
		io.write("Enter login: ");
		String login = io.readConsole();
		if (!isLoginValid(users, io, login)) {
			return null;
		}
		io.write("Enter password: ");
		String password = io.readConsole();

		io.write("Confirm password: ");
		String confirmPassword = io.readConsole();
		if (!isPasswordValid(password, confirmPassword, io)) {
			return null;
		}

		io.write("Enter email: ");
		String email = io.readConsole();
		if (!isEmailValid(email)) {
			io.writeln("Email is invalid!");
			io.writeln("");
			return null;
		}

		User newUser = new User(login, password, email);
		users.add(newUser);
		convertToJSON(users);
		io.writeln("You are registered");
		io.writeln("");
		return newUser;

	}

	private boolean isPasswordValid(String password, String confirmPassword, IO io) {
		if (!password.equals(confirmPassword)) {
			io.writeln("Password is invalid!");
			io.writeln("");
			return false;
		}

		return true;
	}

	private boolean isLoginValid(List<User> users, IO io, String login) {
		if (login.isEmpty()) {
			io.writeln("Login is invalid!");
			io.writeln("");
			return false;
		}

		for (User it : users) {
			if (login.equals(it.getLogin())) {
				io.writeln("User with login " + login + " alredy exists!");
				io.writeln("");
				return false;
			}
		}
		return true;
	}

	private boolean isEmailValid(String email) {
		final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);

		return matcher.matches();
	}
	
	private void convertToJSON(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		 try {
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			mapper.writeValue(new FileWriter(USERS_FILE_NAME), object);
		} catch (IOException e) {
			e.printStackTrace();
		}
   }
}
