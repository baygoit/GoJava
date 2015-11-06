import java.util.HashMap;
import java.util.Map;

public class ThirdCategory {
	Map<Integer, Project> thirdProjects = new HashMap<>();
	{ thirdProjects.put(1, new Project("Name31", "Description31", 31000, 3100, 31, "history31", "link31", "questions31"));
	thirdProjects.put(2, new Project("Name32", "Description32", 32000, 3200, 32, "history32", "link32", "questions32"));
	thirdProjects.put(3, new Project("Name33", "Description33", 33000, 3300, 33, "history33", "link33", "questions33"));
	}
	
	Map<Integer, Project> getProjects() {		
		return thirdProjects;		
	}
	
}
