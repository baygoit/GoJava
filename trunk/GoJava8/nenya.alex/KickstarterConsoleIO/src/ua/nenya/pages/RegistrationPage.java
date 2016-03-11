package ua.nenya.pages;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ua.nenya.users.User;
import ua.nenya.util.IO;

public class RegistrationPage {
	private static final String LP_FILE_NAME = "src/resources/users.txt";

	public User registration(List<User> users, IO io) {
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
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(LP_FILE_NAME, false));
			output.writeObject(users);
			output.close();
		} catch (Exception e) {
		}
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
}
