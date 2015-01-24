
public class Output {
	public void hello(){
		System.out.println("Welcome to the place where your dreams become real possibilities! ;)");
	}
	
	public void categoriesMenu(Categories c){ 
		System.out.println("Choose a category:");
		c.showList();
	}
	
	public void projectsMenu(MyCategory c){ 
		System.out.println("Choose a project:");
		c.showList();
	}
}
