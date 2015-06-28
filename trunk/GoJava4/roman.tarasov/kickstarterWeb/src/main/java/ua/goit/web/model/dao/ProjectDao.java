package ua.goit.web.model.dao;


import java.util.List;


public interface ProjectDao {

	List<Project> sortProjectsByCategoryID(int categoryID) throws  KickstarterException;

	Project getProjectById(int ID) throws  KickstarterException;

	void updateProject(Project project) throws  KickstarterException;

}
