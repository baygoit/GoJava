package com.kickstarter.dao.Interfaces;

import java.util.List;


import com.kickstarter.model.Project;

public interface ProjectDao {

	
	public List<Project> getAllProjectsForCategory(int categoryId);

	public Project getOneProject(int projectNumber);

	public void updateProject(Project p);

}