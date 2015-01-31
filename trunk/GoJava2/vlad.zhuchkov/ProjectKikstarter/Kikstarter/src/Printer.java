import java.util.ArrayList;




public class Printer implements Output {
	
	public void showCategoryCatalog(CategoryCatalog catalog){
		ArrayList<Category> list = catalog.getCatalogList();
		int i=1;
		for (Category t : list)
			print((i++)+")"+t.getName());
		
	}
	public void showCategoryName(CategoryCatalog catalog,int num){
		ArrayList<Category> list = catalog.getCatalogList();
		print(list.get(num).getName());
	}
	public void showProjects(Category category){
		ArrayList<Project> Projects = category.getProjectCatalog();
		for (int i=0;i<Projects.size();i++){
			showProjectPreviev(category.getProject(i));
		}
	}
	public void showProjectInfo(Project project){
		showProjectPreviev(project);
		showProjectDetailedInfo(project);
	}
	private void showProjectPreviev(Project project){
		print(project.getName());
		print(project.getDescription());
		ProjectParameters param = project.getParameters();
		print("Need to collect "+param.getCost()+"$");
		print("Already Collected "+param.getAlreadyCollected()+"$");
		print("Days left "+param.getDays());
		}
	private void showProjectDetailedInfo(Project project){
		ProjectParameters.DetailedParameters param = project.getParameters().getDetailedParameters();
		print(param.getHisory());
		print("Link on demo video: "+param.getDemoLink());
		print("FAQ: "+param.getFaqLink());	
		}
	public void print (String s){
		System.out.println(s);
	}
	
}
