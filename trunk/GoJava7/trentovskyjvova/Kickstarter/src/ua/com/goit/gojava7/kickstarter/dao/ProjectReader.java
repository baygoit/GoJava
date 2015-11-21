package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Project;

public interface ProjectReader {
	
	List<Project> readProjects();
	
}
