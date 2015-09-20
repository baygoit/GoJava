package ua.com.goit.gojava.kickstarter.output;

import java.util.List;

import ua.com.goit.gojava.kickstarter.data.Category;
import ua.com.goit.gojava.kickstarter.data.CategoryCatalog;
import ua.com.goit.gojava.kickstarter.data.Parameters;
import ua.com.goit.gojava.kickstarter.data.Project;
import ua.com.goit.gojava.kickstarter.data.Status;

public class Printer {
	Output out;

	public Printer(Output out) {
		this.out = out;
	}

	public void showCategoryCatalog(CategoryCatalog catalog) {
		List<String> list = catalog.getCatalog();
		int i = 1;
		for (String t : list)
			out.print((i++) + ")" + t);

	}

	public void showCategoryName(CategoryCatalog catalog, int num) {
		List<String> list = catalog.getCatalog();
		out.print(list.get(num));
	}

	public void showProjects(Category category) {

		for (int i = 0; i < category.size(); i++) {
			showProjectPreviev(category.getProject(i));
		}
	}

	public void showProjectInfo(Project project) {
		showProjectPreviev(project);
		showProjectDetailedInfo(project);
	}

	private void showProjectPreviev(Project project) {
		out.print(project.getName());
		out.print(project.getDescription());
		Status param = project.getStatus();
		out.print("Need to collect " + param.getCost() + "$");

		out.print("Already Collected " + param.getAlreadyCollected() + "$");
		out.print("Days left " + param.getDays());
	}

	private void showProjectDetailedInfo(Project project) {
		Parameters status = project.getParameters();
		out.print(status.getHisory());
		out.print("Link on demo video: " + status.getDemoLink());
		out.print("FAQ: " + status.getFaqLink());
	}

	public void print(String s) {
		out.print(s);

	}

}
