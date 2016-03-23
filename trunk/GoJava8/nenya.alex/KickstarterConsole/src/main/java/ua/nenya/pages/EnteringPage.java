package ua.nenya.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ua.nenya.pages.RegistrationPage;
import ua.nenya.project.Category;
import ua.nenya.project.User;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;
import ua.nenya.enums.RegistrationPageEnum;
import ua.nenya.main.KickstarterInitilizer;

public class EnteringPage {

	private CreatingProjectPage createProjectPage = new CreatingProjectPage();
	private RegistrationPage registrationPage = new RegistrationPage();

	public void enter(KickstarterInitilizer initilizer, IO io, ListUtilits listUtil) {
		List<RegistrationPageEnum> list = new ArrayList<>(Arrays.asList(RegistrationPageEnum.values()));
		int index;
		while ((index = listUtil.choseIndexFromList(list, io)) != 0) {
			RegistrationPageEnum item = list.get(index - 1);
			io.writeln("You've chosen " + item.getName());
			if (item.equals(list.get(0))) {
				io.write("Enter login: ");
				String login = io.readConsole();
				io.write("Enter password: ");
				String password = io.readConsole();
				io.writeln("");
				enterCreateProjectPage(initilizer, io, listUtil, login, password);
			} else {

				User newUser = registrationPage.registration(initilizer, io);
				if (newUser == null) {
					return;
				}
				String login = newUser.getLogin();
				String password = newUser.getPassword();
				enterCreateProjectPage(initilizer, io, listUtil, login, password);
				io.writeln("");
			}

		}

	}

	private void enterCreateProjectPage(KickstarterInitilizer initilizer, IO io, ListUtilits listUtil,
			String login, String password) {
		List<User> users = initilizer.getUserDao().getUsers();
		List<Category> categories = initilizer.getCategoryDao().getCategories();
		if (isUserValid(users, io, login, password)) {
			createProjectPage.createProject(io, categories, listUtil);
		}
	}

	private boolean isUserValid(List<User> users, IO io, String login, String password) {
		if (!login.isEmpty()) {
			for (User it : users) {
				if (it.getLogin().equals(login) && it.getPassword().equals(password)) {
					return true;
				}
			}
		}
		io.writeln("You are not registered!");
		io.writeln("");
		return false;
	}

}
