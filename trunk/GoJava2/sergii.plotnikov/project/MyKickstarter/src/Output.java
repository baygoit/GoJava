
public class Output {
		
	public void hello(){
		System.out.println("Welcome to the place where your dreams become real possibilities! ;)");
	}
	
	public void categoriesMenu(Categories c){ 
		System.out.println("Choose a category:");
		c.showList();
	}
	
	public void projectsMenu(MyCategory category){ 		
		System.out.println("You have chosen Category " + category.getTitle());
		System.out.println("Choose a project:");
		category.showList();
	}


	public void showProject(Project project) { project.showProject();}
}
