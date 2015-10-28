package vadyazakusylo.kickstarter.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vadyazakusylo.kickstarter.model.Category;
import vadyazakusylo.kickstarter.model.Project;
import vadyazakusylo.kickstarter.model.dao.ProjectsDao;
import vadyazakusylo.kickstarter.model.exception.GettingDateException;

public class ProjectsDaoMySql implements ProjectsDao {
	private Connection connection;

	public ProjectsDaoMySql(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Project> getProjectsList(Category category) throws GettingDateException {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectProjects());
			preparedStatement.setString(1, category.getName());
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Project> projects = new ArrayList<Project>();
			while (resultSet.next()) {
				String name = resultSet.getString("project.project");
				String shortDescription = resultSet.getString("description.description");
				double needMoney = resultSet.getDouble("project.needMoney");
				double currentMoney = resultSet.getDouble("project.currentMoney");
				int daysLeft = resultSet.getInt("project.daysLeft");
				String urlVideo = resultSet.getString("description.urlVideo");
				projects.add(new Project(name, shortDescription, needMoney, currentMoney, daysLeft,
						urlVideo));
			}
			return projects;
		} catch (SQLException e) {
			System.out.println("Can't connect to table \"Projects\"");
			throw new GettingDateException();
		}
	}

	private String selectProjects() {
		StringBuilder sql = new StringBuilder();
		sql.append("select project.project, ");
		sql.append("description.description, ");
		sql.append("project.needMoney, project.currentMoney, ");
		sql.append("project.daysLeft, description.urlVideo ");
		sql.append("from project inner join description ");
		sql.append("on project.id_project = description.id_project ");
		sql.append("and project.id_category = ");
		sql.append("(select id_category from category ");
		sql.append("where category = ?);");
		return sql.toString();
	}
}
