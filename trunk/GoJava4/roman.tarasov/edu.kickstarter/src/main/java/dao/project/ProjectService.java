package dao.project;


import java.util.List;

import dao.pool.KickstarterException;

public interface ProjectService {

	List<Project> sortProjectsByCategoryID(int categoryID) throws  KickstarterException;

	Project getProjectById(int ID) throws  KickstarterException;

	void updateProject(Project project) throws  KickstarterException;

}
