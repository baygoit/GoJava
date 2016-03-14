package ua.nenya.pages;

import java.util.List;

import ua.nenya.pages.ProjectPage;
import ua.nenya.project.Category;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;

public class CategoriesPage {

	private ProjectPage projectPage = new ProjectPage();

	public void showAllCategories(List<Category> categories, IO io, ListUtilits listUtil) {
		int index;
		while ((index = listUtil.choseIndexFromList(categories, io)) != 0) {
			Category chosenCategory = categories.get(index - 1);
			io.writeln("You've chosen " + chosenCategory.getName());
			projectPage.showTotalProject(io, chosenCategory, listUtil);
		}
		
	}
}
