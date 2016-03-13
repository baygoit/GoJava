package ua.nenya.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ua.nenya.enums.EnteringPageEnum;
import ua.nenya.project.Category;
import ua.nenya.project.Project;
import ua.nenya.project.Projects;
import ua.nenya.users.User;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;

public class EnteringPage {

	private CreatingProjectPage createProjectPage = new CreatingProjectPage();
	private RegistrationPage registrationPage = new RegistrationPage();

	public void enter(List<User> users, List<Category> categories, Projects projects, IO io, ListUtilits listUtil) {
		List<EnteringPageEnum> list = new ArrayList<>(Arrays.asList(EnteringPageEnum.values()));
		int index;
		while ((index = listUtil.choseIndexFromList(list, io)) != 0) {
			EnteringPageEnum item = list.get(index - 1);
			io.writeln("You've chosen " + item.getName());
			if (item.equals(list.get(0))) {
				io.write("Enter login: ");
				String login = io.readConsole();
				io.write("Enter password: ");
				String password = io.readConsole();
				io.writeln("");
				enterCreateProjectPage(users, categories, projects, io, listUtil, login, password);
			} else {

				User newUser = registrationPage.registration(users, io);
				if (newUser == null) {
					return;
				}
				String login = newUser.getLogin();
				String password = newUser.getPassword();
				enterCreateProjectPage(users, categories, projects, io, listUtil, login, password);
				io.writeln("");
			}

		}

	}

	private void enterCreateProjectPage(List<User> users, List<Category> categories, Projects projects, IO io, ListUtilits listUtil,
			String login, String password) {
		if (isUserValid(users, io, login, password)) {
			Project newProject = createProjectPage.createProject(io, categories, listUtil);
			projects.getProjects().add(newProject);
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
