package vadya_zakusylo.kickstarter.my_sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vadya_zakusylo.kickstarter.model.Category;
import vadya_zakusylo.kickstarter.model.Project;
import vadya_zakusylo.kickstarter.model.ProjectImpl;
import vadya_zakusylo.kickstarter.model.dao.ProjectsDao;

public class ProjectsDaoImpl implements ProjectsDao {
	private Connection connection;
	private List<Project> projects = new ArrayList<Project>();

	public ProjectsDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Project> getProjectsList(Category category) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectProjects());
			preparedStatement.setString(1, category.getName());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("project.project");
				String shortDescription = resultSet.getString("description.description");
				double needMoney = resultSet.getDouble("project.needMoney");
				double currentMoney = resultSet.getDouble("project.currentMoney");
				int daysLeft = resultSet.getInt("project.daysLeft");
				String urlVideo = resultSet.getString("description.urlVideo");
				projects.add(new ProjectImpl(name, shortDescription, needMoney, currentMoney,
						daysLeft, urlVideo));
			}
		} catch (SQLException e) {
			System.out.println("Can't connect to table \"Projects\"");
		}
		return projects;
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

	@Override
	public double getCurrenMoney(String nameProject) {
		double currentMoney = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectCurrentMoney());
			preparedStatement.setString(1, nameProject);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				currentMoney = resultSet.getDouble("project.currentMoney");
			}
		} catch (SQLException e) {
			System.out.println("Can't connect to table \"Projects\"");
		}
		return currentMoney;
	}

	private String selectCurrentMoney() {
		StringBuilder sql = new StringBuilder();
		sql.append("select currentMoney ");
		sql.append("from project ");
		sql.append("where project = ?;");
		return sql.toString();
	}

	@Override
	public void setCurrentMoney(double money, String nameProject) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateCurrentMoney());
			preparedStatement.setDouble(1, money);
			preparedStatement.setString(2, nameProject);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Transaction isn't successful");
		}
	}

	private String updateCurrentMoney() {
		StringBuilder sql = new StringBuilder();
		sql.append("update project ");
		sql.append("set currentMoney = ? ");
		sql.append("where project = ?;");
		return sql.toString();
	}

	@Override
	public void setQuestion(String question, String name) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuestion());
			preparedStatement.setString(1, question);
			preparedStatement.setString(2, name);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Problems with connect. Try again.");
		}
	}

	private String updateQuestion() {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into questions ");
		sql.append("(question, id_project)");
		sql.append("values (?, ");
		sql.append("(select id_project");
		sql.append("from project ");
		sql.append("where project = ?));");
		return sql.toString();
	}
}
