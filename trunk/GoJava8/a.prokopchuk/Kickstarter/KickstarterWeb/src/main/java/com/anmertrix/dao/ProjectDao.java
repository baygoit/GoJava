package com.anmertrix.dao;

import java.util.List;

import com.anmertrix.domain.Project;

public interface ProjectDao {
	
	List<Project> getProjectsByCategoryId(long categoryId);
	
	boolean projectExists(long projectId);

	Project getProjectById(long projectId);

}
