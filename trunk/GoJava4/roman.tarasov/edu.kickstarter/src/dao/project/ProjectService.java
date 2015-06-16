package dao.project;

import java.sql.SQLException;
import java.util.List;

import database.KickstarterException;

public interface ProjectService {

	List<Project> sortProjectsByCategoryID(int categoryID) throws  KickstarterException;

	Project getProjectById(int ID) throws SQLException, KickstarterException;

}
