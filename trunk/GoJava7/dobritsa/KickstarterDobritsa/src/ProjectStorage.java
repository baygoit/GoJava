import java.util.HashMap;
import java.util.Map;

public class ProjectStorage {
	
	private static Map<Integer, Project> projectsInCategory = new HashMap<Integer, Project>();	
	
	// OLEG SRL violated
	public static void setProjectStorage(Integer i) {
		if (i == 0) {
			FirstCategory firstCategory = new FirstCategory();
			projectsInCategory = firstCategory.getProjects();		
		} else if (i == 1) {
			SecondCategory secondCategory = new SecondCategory();
			projectsInCategory = secondCategory.getProjects();	
		} else if (i == 2) {
			ThirdCategory thirdCategory = new ThirdCategory();
			projectsInCategory = thirdCategory.getProjects();	
		} else System.out.println("wrong choice");		
	}
	
	// OLEG what?
	public static Map<Integer, Project> getProjectFourth() {return projectsInCategory;}
	
	// OLEG SRL violated
	public static void printAllShort() {
		System.out.println("_________________________________________");
		System.out.println("\n0: for return to list of categories");
		for(Map.Entry<Integer, Project> item : projectsInCategory.entrySet()){			
			System.out.println("\n" + item.getKey() + ":");
			item.getValue().printShort();
		}				
	}
	
	// OLEG SRL violated
	public static void printOneFull() {	
		System.out.println("_________________________________________");
		System.out.println("\n0: for return to Projects");
		for(Map.Entry<Integer, Project> item : projectsInCategory.entrySet()){			
			System.out.println("\n" + item.getKey() + ":");
			item.getValue().printFull();
		}				
	}
	
	public static Project getProject(Integer index) {
		return projectsInCategory.get(index);		
	}		
}
