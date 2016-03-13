package ua.nenya.main;


import java.util.List;

import ua.nenya.dao.file.QuoteDaoFileImpl;
import ua.nenya.dao.memory.QuoteDaoMemoryImpl;
import ua.nenya.pages.EnteringPage;
import ua.nenya.pages.ProjectPage;
import ua.nenya.project.Category;
import ua.nenya.project.Projects;
import ua.nenya.project.Quote;
import ua.nenya.users.User;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;

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
		io.writeln(new QuoteDaoMemoryImpl().getRandomQuote().getName());
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
