package com.anmertrix.dao;

import java.util.List;

import com.anmertrix.domain.Project;

public interface ProjectDao {
	
	List<Project> getProjectsByCategoryId(int categoryId);
	
	boolean projectExists(int projectId);

	Project getProjectById(int projectId);

}
