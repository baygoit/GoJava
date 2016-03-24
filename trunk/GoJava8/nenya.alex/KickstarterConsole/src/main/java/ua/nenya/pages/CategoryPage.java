package ua.nenya.pages;

import java.util.List;

import ua.nenya.main.DaoInitilizer;
import ua.nenya.pages.ProjectPage;
import ua.nenya.project.Category;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;

public class CategoryPage {

	private ProjectPage projectPage = new ProjectPage();

	public void showAllCategories(DaoInitilizer initilizer, IO io, ListUtilits listUtil) {
		int index;
		List<Category> categories = initilizer.getCategoryDao().initCategories();
		while ((index = listUtil.choseIndexFromList(categories, io)) != 0) {
			Category chosenCategory = categories.get(index - 1);
			io.writeln("You've chosen " + chosenCategory.getName());
			projectPage.showAllProjectsOfCategory(initilizer, io, chosenCategory, listUtil);
		}
		
	}
}
