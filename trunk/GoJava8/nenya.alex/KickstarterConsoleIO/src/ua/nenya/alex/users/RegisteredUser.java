package ua.nenya.alex.users;


import ua.nenya.alex.project.Category;
import ua.nenya.alex.project.Project;
import ua.nenya.alex.util.IO;
import ua.nenya.alex.util.ListUtilits;

public class RegisteredUser {

	private Admin admin = new Admin();

	public boolean enter(IO io, User user, Category category, 
			Project project, ListUtilits listUtil) {
		boolean b = false;
		io.write("Enter login: ");
		String login = io.readConsole();
		io.write("Enter password: ");
		String password = io.readConsole();
		io.writeEmpty();
		if (admin.isAdmin(login, password)) {
			admin.enterLikeAdmin(category, io, user, listUtil);
			b = true;
		} else {
			if (user.isUserValid(io, login, password)) {
				user.enter(user, category, project, io, login, password, listUtil);
				b = true;
			}
		}
		return b;
	}
}
