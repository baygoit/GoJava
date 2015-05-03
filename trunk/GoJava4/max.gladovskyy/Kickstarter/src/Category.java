import java.util.ArrayList;


public class Category {
	private String name;
	private ArrayList<Project> projects = new ArrayList<Project>();
	
	public Category(String name) {
		this.name = name;
	}

	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}

	public String getName() {
		return name;
	}

	public void print() {
		Console.clearScreen();
		System.out.println("Category:" + name);
		System.out.println();
		System.out.println("Choose project to explore and press enter:");
		for (Project project: projects) {
			System.out.println(projects.indexOf(project)+1+") "+project.getName());
			System.out.println(project.getDescription());
			System.out.println(project.getMoneyNeeded() + " money needed.");
			System.out.println(project.getMoneyCollected() + "money collected");
			System.out.println(project.getDaysLeft() + "days left.");
			System.out.println();
		}
		System.out.println("0) Exit.");
		int userChois = Console.getUserChois(projects.size(),Console.EXIT);
		if (userChois == 0) {
			MainPage.getMainPage().print();
		} else projects.get(userChois-1).print();
		
	}

}
