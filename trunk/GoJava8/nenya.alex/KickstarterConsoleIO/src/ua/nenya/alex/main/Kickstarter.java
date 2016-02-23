package ua.nenya.alex.main;

import java.util.Arrays;
import java.util.List;

import ua.nenya.alex.pages.RegistrationPage;
import ua.nenya.alex.project.Category;
import ua.nenya.alex.project.Project;
import ua.nenya.alex.project.Quote;
import ua.nenya.alex.users.RegisteredUser;
import ua.nenya.alex.users.User;
import ua.nenya.alex.util.IO;
import ua.nenya.alex.util.ListUtilits;

public class Kickstarter {

	public Kickstarter(Category category, Project project, IO io, User user) {
		this.category = category;
		this.project = project;
		this.io = io;
		this.user = user;
	}

	private User user;
	private Category category;
	private Project project;
	private IO io;
	
	private RegisteredUser registeredUser = new RegisteredUser();
	private ListUtilits listUtil = new ListUtilits();
	


	public boolean run() {
		boolean b = false;
		io.writeln(new Quote().showQuote());
		io.writeEmpty();
		List<IncomingsEnum> list = Arrays.asList(IncomingsEnum.values());
		int index;

		while ((index = listUtil.choseIndexFromList(list, io)) != 0) {
			IncomingsEnum someIncoming = list.get(index-1);
			if (someIncoming == IncomingsEnum.GUEST) {
				user.enter(user, category, project, io, "", "", listUtil);
				b = true;
			} else {
				if (someIncoming == IncomingsEnum.REGISTRATION) {
					User newUser = new RegistrationPage().registration(user, io);
					b = true;
					if(newUser != null){
						user.enter(user, category, project, io,
								newUser.getLogin(), newUser.getPassword(), listUtil);
						b = true;
						io.writeEmpty();
					}
				} else {
					registeredUser.enter(io, user, category, project, listUtil);
					b = true;
				}

			}

		}
		return b;
	}

}
