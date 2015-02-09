import java.util.ArrayList;

public class Printer {
	Output out;

	public Printer(Output out) {
		this.out = out;
	}

	public void showCategoryCatalog(CategoryCatalog catalog) {
		Category[] list = catalog.getCatalogList();
		int i = 1;
		for (Category t : list)
			out.print((i++) + ")" + t.getName());

	}

	public void showCategoryName(CategoryCatalog catalog, int num) {
		Category[] list = catalog.getCatalogList();
		out.print(list[num].getName());
	}

	public void showProjects(Category category) {
		ArrayList<Project> Projects = category.getProjectCatalog();
		for (int i = 0; i < Projects.size(); i++) {
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
		ProjectParameters param = project.getParameters();
		out.print("Need to collect " + param.getCost() + "$");
		
		out.print("Already Collected " + param.getAlreadyCollected() + "$");
		out.print("Days left " + param.getDays());
	}

	private void showProjectDetailedInfo(Project project) {
		ProjectParameters.DetailedParameters param = project.getParameters()
				.getDetailedParameters();
		out.print(param.getHisory());
		out.print("Link on demo video: " + param.getDemoLink());
		out.print("FAQ: " + param.getFaqLink());
	}

	public void print(String s) {
		out.print(s);
		
	}

	

}
