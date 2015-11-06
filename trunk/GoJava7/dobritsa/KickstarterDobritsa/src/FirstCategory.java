import java.util.HashMap;
import java.util.Map;

public class FirstCategory {
	Map<Integer, Project> firstCategory = new HashMap<>();
	{firstCategory.put(1, new Project("Name11", "Description11", 11000, 1100, 11, "history11", "link11", "questions11"));
	firstCategory.put(2, new Project("Name12", "Description12", 12000, 1200, 12, "history12", "link12", "questions12"));
	firstCategory.put(3, new Project("Name13", "Description13", 13000, 1300, 13, "history13", "link13", "questions13"));
	}
	
	Map<Integer, Project> getProjects() {		
		return firstCategory;		
	}
	
}
