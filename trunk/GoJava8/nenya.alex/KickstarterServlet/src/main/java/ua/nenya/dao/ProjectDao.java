package ua.nenya.dao;

import java.util.List;

import ua.nenya.domain.Project;

public interface ProjectDao {

	List<Project> getProjectsByCategoryId(Long id);
	Project getProjectByProjectId(Long proId);
	boolean isProjectExist(Long proId);
}
