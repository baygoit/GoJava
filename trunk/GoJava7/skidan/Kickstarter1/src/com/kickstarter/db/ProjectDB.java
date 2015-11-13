package com.kickstarter.db;

import java.util.HashMap;
import java.util.Map;

import com.kickstarter.model.Project;


public class ProjectDB {
	
	public static Map<Integer, Project> allProjectsList;

	public ProjectDB() {
		allProjectsList = ProjectsFiller();
	}

	

	public static Map<Integer, Project> ProjectsFiller() {
		
		Map<Integer, Project> allProjects = new HashMap<>();
		
		allProjects.put(1, new Project(1, "educationProjec1", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section", "education"));
		allProjects.put(2, new Project(2, "educationProjec2", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section", "education"));
		allProjects.put(3, new Project(3, "educationProjec3", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section", "education"));
		allProjects.put(4, new Project(4, "educationProjec4", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section", "education"));

		allProjects.put(5, new Project(1, "itproject1", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section", "it"));
		allProjects.put(6, new Project(2, "itproject2", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section", "it"));
		allProjects.put(7, new Project(3, "itproject3", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section", "it"));
		allProjects.put(8, new Project(4, "itproject4", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section", "it"));

		allProjects.put(9, new Project(1, "sportProjec1", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section", "sport"));
		allProjects.put(10, new Project(2, "sportProjec2", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section", "sport"));
		allProjects.put(11, new Project(3, "sportProjec3", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section", "sport"));
		allProjects.put(12, new Project(4, "sportProjec4", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "Ask questions section", "sport"));
		return allProjects;
	}
}