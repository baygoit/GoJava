package com.kickstarter.dao.interfaces;

import java.util.List;


import com.kickstarter.model.Project;

public interface ProjectDaoInterface {

	public List<Project> getAllList();
	
	public List<Project> getAll(String categoryTitle);

	public Project getOne(int projectNumber);

	public void update(Project p);

}