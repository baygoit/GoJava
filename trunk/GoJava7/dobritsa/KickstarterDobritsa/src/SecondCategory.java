import java.util.HashMap;
import java.util.Map;

public class SecondCategory {
	Map<Integer, Project> secondCategory = new HashMap<>();
	{ secondCategory.put(1, new Project("Name21", "Description21", 21000, 2100, 21));
	secondCategory.put(2, new Project("Name22", "Description22", 22000, 2200, 22));
	secondCategory.put(3, new Project("Name23", "Description23", 23000, 2300, 23));
	}
	
	Map<Integer, Project> getProjects() {		
		return secondCategory;		
	}
	
}
