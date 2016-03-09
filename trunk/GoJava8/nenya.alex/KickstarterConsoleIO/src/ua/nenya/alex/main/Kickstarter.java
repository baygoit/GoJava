package ua.nenya.alex.main;


import java.util.List;

import ua.nenya.alex.pages.EnteringPage;
import ua.nenya.alex.pages.ProjectPage;
import ua.nenya.alex.project.Category;
import ua.nenya.alex.project.Projects;
import ua.nenya.alex.project.Quote;
import ua.nenya.alex.users.User;
import ua.nenya.alex.util.IO;
import ua.nenya.alex.util.ListUtilits;

public class Kickstarter {

	public Kickstarter(List<User> users, List<Category> categories, Projects projects, IO io) {
		this.categories = categories;
		this.projects = projects;
		this.io = io;
		this.users = users;
	}

	private List<User> users;
	private List<Category> categories;
	private Projects projects;
	private IO io;
	
	private ListUtilits listUtil = new ListUtilits();
	private EnteringPage enteringPage = new EnteringPage();
	private ProjectPage projectPage = new ProjectPage();


	public void run() {
		io.writeln(new Quote().showQuote());
		io.writeln("");
		int index;
		while ((index = listUtil.choseIndexFromList(categories, io)) != 0) {
			Category chosenCategory = categories.get(index-1);
			io.writeln("You've chosen "+chosenCategory.getName());
			if (chosenCategory.equals(categories.get(categories.size()-1))) {
					enteringPage.enter(users, categories, projects, io, listUtil);
				
			} else {
				projectPage.showTotalProject(projects, io, chosenCategory, listUtil);
			}
		}
	}

}
