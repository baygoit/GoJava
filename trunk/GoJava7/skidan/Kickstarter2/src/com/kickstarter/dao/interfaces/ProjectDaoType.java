package com.kickstarter.dao.interfaces;

import java.util.List;

import com.kickstarter.model.Category;
import com.kickstarter.model.Project;

public abstract class ProjectDaoType {

	protected ProjectDaoInterface projectDaoInterface;

	public ProjectDaoType() {

	}

	public List<Project> getAll(Category category) {

		return projectDaoInterface.getAll(category);
	}

	public Project getOne(int projectNumber) {

		return projectDaoInterface.getOne(projectNumber);

	}

	public void update(Project p) {
		projectDaoInterface.update(p);

	}

	public List<Project> getAllList() {
		return projectDaoInterface.getAllList();
	}

	public void setType(ProjectDaoInterface projectDao) {
		this.projectDaoInterface = projectDao;
	}

}