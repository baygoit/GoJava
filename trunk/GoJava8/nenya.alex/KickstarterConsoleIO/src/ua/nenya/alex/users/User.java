package ua.nenya.alex.users;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

import ua.nenya.alex.pages.CreateProjectPage;
import ua.nenya.alex.pages.ProjectPage;
import ua.nenya.alex.pages.RegistrationPage;
import ua.nenya.alex.project.Category;
import ua.nenya.alex.project.Project;
import ua.nenya.alex.util.IO;
import ua.nenya.alex.util.ListUtilits;

public class User implements Externalizable {
	private String login;
	private String password;
	private String email;
	private CreateProjectPage createProjectPage;
	private List<User> usersList = new ArrayList<>();
	private ProjectPage projectPage;
	private RegistrationPage registrationPage;


	public List<User> getUsersList() {
		return usersList;
	}

	public User(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public User() {
		this.createProjectPage = new CreateProjectPage();
		this.projectPage = new ProjectPage();
		this.registrationPage = new RegistrationPage();
	}

	public boolean isUserValid(IO io, String login, String password) {
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

	public boolean enter(User user, Category category, Project project, IO io, String login, String password,
			ListUtilits listUtil) {
		boolean b = false;
		List<Category> listOfCategories = category.getCategoriesList();
		int outerIndex;
		String log = login;
		String pas = password;
		while ((outerIndex = listUtil.choseIndexFromList(listOfCategories, io)) != 0) {
			b = true;
			Category chosenCategory = listOfCategories.get(outerIndex - 1);
			if (chosenCategory.equals(listOfCategories.get(0))) {
				if (isUserValid(io, log, pas)) {
					io.write("Do you want to create a project? (y/n): ");
					if (io.readConsole().equals("y")) {
						Project newProject = createProjectPage.createProject(io, listOfCategories, listUtil);
						project.getProjectsList().add(newProject);
						b = true;
					}
				} else {
					io.write("Are you ready to register? (y/n): ");
					if (io.readConsole().equals("y")) {
						User newUser = registrationPage.registration(user, io);
						if (newUser == null) {
							return true;
						}
						log = newUser.getLogin();
						pas = newUser.getPassword();
					}
					io.writeEmpty();
				}
					b = true;
			} else {
				projectPage.showTotalProject(project, io, chosenCategory, listUtil);
				b = true;
			}

		}
		return b;
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		login = (String) in.readObject();
		password = (String) in.readObject();
		email = (String) in.readObject();
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(login);
		out.writeObject(password);
		out.writeObject(email);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}


}
