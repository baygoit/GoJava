package com.anmertrix.dao;

import java.util.List;

import com.anmertrix.domain.Project;

public interface ProjectDao {
	
	List<Project> getProjects(long categoryId);
	
	boolean isExists(long projectId);

	Project getProject(long projectId);

}
