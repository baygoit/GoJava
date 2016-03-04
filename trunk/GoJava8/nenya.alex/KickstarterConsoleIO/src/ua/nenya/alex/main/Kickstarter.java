package ua.nenya.alex.main;


import java.util.List;

import ua.nenya.alex.pages.EnteringPage;
import ua.nenya.alex.pages.ProjectPage;
import ua.nenya.alex.project.Category;
import ua.nenya.alex.project.Project;
import ua.nenya.alex.project.Quote;
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
	
	private ListUtilits listUtil = new ListUtilits();
	private EnteringPage enteringPage = new EnteringPage();
	private ProjectPage projectPage = new ProjectPage();


	public boolean run() {
		boolean b = false;
		io.writeln(new Quote().showQuote());
		io.writeEmpty();
		List<Category> listOfCategories = category.getCategoriesList();
		int index;
		while ((index = listUtil.choseIndexFromList(listOfCategories, io)) != 0) {
			b = true;
			Category chosenCategory = listOfCategories.get(index-1);
			io.writeln("You've chosen "+chosenCategory.getName());
			if (chosenCategory.equals(listOfCategories.get(listOfCategories.size()-1))) {
					enteringPage.enterDemo(user, category, project, io, listUtil);
					b = true;
				
			} else {
				projectPage.showTotalProject(project, io, chosenCategory, listUtil);
				b = true;
			}
		}
		return b;
	}

}
