package edu.kickstarter.DAO.project;

import java.sql.SQLException;
import java.util.List;
import edu.kickstarter.entity.Project;

public interface ProjectService {

	List<Project> sortProjectsByCategoryID(int categoryID) throws SQLException;

}
