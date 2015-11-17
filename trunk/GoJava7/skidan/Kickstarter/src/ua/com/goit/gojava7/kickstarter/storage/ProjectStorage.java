package ua.com.goit.gojava7.kickstarter.storage;

import java.util.HashMap;
import java.util.Map;

import ua.com.goit.gojava7.kickstarter.model.Project;



public class ProjectStorage {

	public static Map<Integer, Project> educationProjectsFiller() {
		Map<Integer, Project> educationProjects = new HashMap<>();
		educationProjects.put(1, new Project("educationProjec1", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section"));
		educationProjects.put(2, new Project("educationProjec2", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section"));
		educationProjects.put(3, new Project("educationProjec3", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section"));
		educationProjects.put(4, new Project("educationProjec4", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section"));
		return educationProjects;
	}

	public static Map<Integer, Project> itProjectsFiller() {
		Map<Integer, Project> itProjects = new HashMap<>();
		itProjects.put(1, new Project("itproject1", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section"));
		itProjects.put(2, new Project("itproject2", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section"));
		itProjects.put(3, new Project("itproject2", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section"));
		itProjects.put(4, new Project("itproject4", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section"));
		return itProjects;
	}

	public static Map<Integer, Project> sportProjectsFiller() {
		Map<Integer, Project> sportProjects = new HashMap<>();
		sportProjects.put(1, new Project("sportProjec1", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section"));
		sportProjects.put(2, new Project("sportProjec2", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section"));
		sportProjects.put(3, new Project("sportProjec3", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section"));
		sportProjects.put(4, new Project("sportProjec4", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section"));
		return sportProjects;
	}

	public static Map<Integer, Project> getProjects(String category) {

		if (category.equals("it")) {
			return itProjectsFiller();
		} else if (category.equals("education")) {
			return educationProjectsFiller();
		} else {
			return sportProjectsFiller();
		}
	}

}
