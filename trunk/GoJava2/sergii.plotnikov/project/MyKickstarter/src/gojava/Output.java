package gojava;

public class Output {
	
	public void out(String message){
		System.out.println(message);
	}
	
	public String hello(){
		return "Welcome to the place where your dreams become real possibilities! ;)\n";
	}
		
	public String projectsMenu(MyCategory category){ 		
		return "You have chosen Category " + category.getTitle()+ "\nChoose a project:\n" +category.showList();
	}

	public String showProject(Project project) { return project.showProject();}
}
