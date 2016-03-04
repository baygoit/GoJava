package ua.nenya.alex.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ua.nenya.alex.enums.EnteringPageEnum;
import ua.nenya.alex.project.Category;
import ua.nenya.alex.project.Project;
import ua.nenya.alex.users.User;
import ua.nenya.alex.util.IO;
import ua.nenya.alex.util.ListUtilits;

public class EnteringPage {

	private CreateProjectPage createProjectPage = new CreateProjectPage();
	private RegistrationPage registrationPage = new RegistrationPage();

	public void enterDemo(User user, Category category, Project project, IO io, ListUtilits listUtil) {
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
				io.writeEmpty();
				enterCreateProjectPage(user, category, project, io, listUtil, login, password);
			} else {

				User newUser = registrationPage.registration(user, io);
				if (newUser == null) {
					return;
				}
				String login = newUser.getLogin();
				String password = newUser.getPassword();
				enterCreateProjectPage(user, category, project, io, listUtil, login, password);
				io.writeEmpty();
			}

		}

	}

	private void enterCreateProjectPage(User user, Category category, Project project, IO io, ListUtilits listUtil,
			String login, String password) {
		if (isUserValid(user, io, login, password)) {
			Project newProject = createProjectPage.createProject(io, category, listUtil);
			project.getProjectsList().add(newProject);
		}
	}

	private boolean isUserValid(User user, IO io, String login, String password) {
		List<User> usersList = user.getUsersList();
		if (!login.isEmpty()) {
			for (User it : usersList) {
				if (it.getLogin().equals(login) && it.getPassword().equals(password)) {
					return true;
				}
			}
		}
		io.writeln("You are not registered!");
		io.writeEmpty();
		return false;
	}

}
