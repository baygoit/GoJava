package ua.com.goit.gojava7.kickstarter.storage;
import java.util.ArrayList;
import java.util.List;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectStorage {
	
	private List<Project> projectsInCategory = new ArrayList<Project>();	
	
	
	
	
	
	//TODO
	// OLEG SRL violated
	//public void setProjectStorage(Integer i) {
	//	if (i == 0) {
	//		MusicCategory musicCategory = new MusicCategory();
	//		projectsInCategory = musicCategory.getProjects();		
	//	} else if (i == 1) {
	//		DanceCategory danceCategory = new DanceCategory();
	//		projectsInCategory = danceCategory.getProjects();	
	//	} else if (i == 2) {
	//		FoodCategory foodCategory = new FoodCategory();
	//		projectsInCategory = foodCategory.getProjects();	
	//	} else System.out.println("wrong choice");		
	//}
	
	//TODO
	// OLEG SRL violated
	public void printAllShort() {
		System.out.println("_________________________________________");
		System.out.println("\n0: for return to list of categories");
		for(int i = 0; i < projectsInCategory.size(); i++){			
			System.out.println("\n" + (i+1) + ":");
			projectsInCategory.get(i).printShort();
		}				
	}
	
	//TODO
	// OLEG SRL violated
	public void printOneFull() {	
		System.out.println("_________________________________________");
		System.out.println("\n0: for return to Projects");
	//	for(Map.Entry<Integer, Project> item : projectsInCategory.entrySet()){			
	//		System.out.println("\n" + item.getKey() + ":");
	//		item.getValue().printFull();
	//	}				
	}
	
	public Project getProject(Integer index) {
		return projectsInCategory.get(index);		
	}		
	
	public Integer size() {
		return projectsInCategory.size();		
	}

	public void add(Project project) {
		projectsInCategory.add(project);		
	}
}
