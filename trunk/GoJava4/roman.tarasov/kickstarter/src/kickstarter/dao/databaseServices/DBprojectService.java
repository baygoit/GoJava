package kickstarter.dao.databaseServices;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import kickstarter.dao.interfaces.iDAO;
import kickstarter.dao.interfaces.iProjectService;
import kickstarter.entity.Project;

public class DBprojectService implements iProjectService {
	List<Project> projects;

	@Override
	public Project getProjectByIndex(int index) {
		return projects.get(index);
	}

	@Override
	public int getProjectsLength() {
		return projects.size();
	}

	@Override
	public Project getProjectById(int ID) {
		int length = projects.size();
		for (int index = 0; index < length; index++) {
			Project currentProject = (Project) projects.get(index);
			if (currentProject.getID() == ID) {
				return currentProject;
			}
		}
		return null;
	}

	@Override
	public List<Project> getAll() {
		return projects;
	}

	@Override
	public void createProjects(iDAO sourceDAO, Connection connection)
			throws SQLException {
		List<Project> projects = sourceDAO.getProjectService().getAll();
		Statement statement = connection.createStatement();
		statement.executeUpdate("DROP TABLE IF EXISTS  projects ");
		statement
				.executeUpdate("CREATE TABLE projects (id_project SERIAL not null PRIMARY KEY,id_category integer, name varchar(255),description varchar(255),amount float8[],days_to_go integer,pledged float8,history varchar(255),link varchar(255),short_description varchar(255))");
		for (Project project : projects) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO projects ("
							+ "id_project,id_category, name, description, amount, days_to_go, pledged, "
							+ "history, link, short_description) values(?,?,?,?,?,?,?,?,?,?)");

			Array sqlArray = connection.createArrayOf("float8",
					project.getAmount());
			preparedStatement.setInt(1, project.getID());
			preparedStatement.setInt(2, project.getCategoryID());
			preparedStatement.setString(3, project.getName());
			preparedStatement.setString(4, project.getDescription());
			preparedStatement.setArray(5, sqlArray);
			preparedStatement.setInt(6, project.getDaysToGo());
			preparedStatement.setDouble(7, project.getPledged());
			preparedStatement.setString(8, project.getHistory());
			preparedStatement.setString(9, project.getLinkToVideo());
			preparedStatement.setString(10, project.getShortDescription());
			preparedStatement.executeUpdate();
		}
	}
}
