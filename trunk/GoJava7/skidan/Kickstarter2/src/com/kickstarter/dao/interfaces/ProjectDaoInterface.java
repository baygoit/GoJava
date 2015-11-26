package com.kickstarter.dao.interfaces;

import java.util.List;

import com.kickstarter.model.Category;
import com.kickstarter.model.Project;

public interface ProjectDaoInterface {

	public List<Project> getAllList();
	
	public List<Project> getAll(Category category);

	public Project getOne(int projectNumber);

	public void update(Project p);

}