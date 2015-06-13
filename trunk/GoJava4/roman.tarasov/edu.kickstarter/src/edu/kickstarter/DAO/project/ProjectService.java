package edu.kickstarter.DAO.project;

import java.sql.SQLException;
import java.util.List;

import edu.kickstarter.database.KickstarterException;
import edu.kickstarter.entity.Project;

public interface ProjectService {

	List<Project> sortProjectsByCategoryID(int categoryID) throws  KickstarterException;

	Project getProjectById(int ID) throws SQLException, KickstarterException;

}
