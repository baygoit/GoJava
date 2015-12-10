package com.kickstarter.memory.storage;

import java.util.ArrayList;
import java.util.List;

import com.kickstarter.model.Project;

public class ProjectDB {

	public static List<Project> allProjectsList;

	public ProjectDB() {
		allProjectsList = ProjectsFiller();
	}

	public static List<Project> ProjectsFiller() {

		List<Project> allProjects = new ArrayList<>();

		allProjects.add(new Project(1, "educationProjec1", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "education"));
		allProjects.add(new Project(2, "educationProjec2", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "education"));
		allProjects.add(new Project(3, "educationProjec3", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "education"));
		allProjects.add(new Project(4, "educationProjec4", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "education"));

		allProjects.add(new Project(5, "itproject1", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "it"));
		allProjects.add(new Project(6, "itproject2", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "it"));
		allProjects.add(new Project(7, "itproject3", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "it"));
		allProjects.add(new Project(8, "itproject4", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "it"));

		allProjects.add(new Project(9, "sportProjec1", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "sport"));
		allProjects.add(new Project(10, "sportProjec2", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "sport"));
		allProjects.add(new Project(11, "sportProjec3", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "sport"));
		allProjects.add(new Project(12, "sportProjec4", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "sport"));
		return allProjects;
	}
}