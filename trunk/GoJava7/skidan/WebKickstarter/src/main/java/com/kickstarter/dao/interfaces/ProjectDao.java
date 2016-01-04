package com.kickstarter.dao.interfaces;

import java.util.List;


import com.kickstarter.model.Project;

public interface ProjectDao {

//	public List<Project> getAllList();
	
	public List<Project> getAll(int categoryId);

	public Project getOne(int projectNumber);

	public void update(Project p);

}