import java.util.List;
//TODO Deal with that. implement SRP 
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
