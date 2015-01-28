import java.util.ArrayList;




public class Printer {
	
	public void showCategoryCatalog(CategoryCatalog catalog){
		ArrayList<Category> list = catalog.getCatalogList();
		for (int i=0;i<list.size();i++)
			System.out.println((i+1)+")"+list.get(i).getName());
		
	}
	public void showCategoryName(CategoryCatalog catalog,int num){
		ArrayList<Category> list = catalog.getCatalogList();
		System.out.println(list.get(num).getName());
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
		System.out.println(project.getName());
		System.out.println(project.getDescription());
		ProjectParameters param = project.getParameters();
		System.out.println("Need to collect "+param.getCost()+"$");
		System.out.println("Already Collected "+param.getAlreadyCollected()+"$");
		System.out.println("Days left "+param.getDays());
		}
	private void showProjectDetailedInfo(Project project){
		ProjectParameters.DetailedParameters param = project.getParameters().getDetailedParameters();
		System.out.println(param.getHisory());
		System.out.println("Link on demo video: "+param.getDemoLink());
		System.out.println("FAQ: "+param.getFaqLink());	
		}
	public void print (String s){
		System.out.println(s);
	}
}
