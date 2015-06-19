package vadyazakusylo.kickstarter.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vadyazakusylo.kickstarter.model.Project;
import vadyazakusylo.kickstarter.model.dao.ProjectDao;
import vadyazakusylo.kickstarter.model.exception.GettingDateException;

public class ProjectDaoMySql implements ProjectDao {
	private Connection connection;

	public ProjectDaoMySql(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Project getProject(String projectName) {
		Project project = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectProject());
			preparedStatement.setString(1, projectName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("project.project");
				String shortDescription = resultSet.getString("description.description");
				double needMoney = resultSet.getDouble("project.needMoney");
				double currentMoney = resultSet.getDouble("project.currentMoney");
				int daysLeft = resultSet.getInt("project.daysLeft");
				String urlVideo = resultSet.getString("description.urlVideo");
				project = new Project(name, shortDescription, needMoney, currentMoney, daysLeft,
						urlVideo);
			}
		} catch (SQLException e) {
			System.out.println("Can't connect to table \"Projects\"");
			throw new GettingDateException();
		}
		return project;
	}

	private String selectProject() {
		StringBuilder sql = new StringBuilder();
		sql.append("select project.project, ");
		sql.append("description.description, ");
		sql.append("project.needMoney, project.currentMoney, ");
		sql.append("project.daysLeft, description.urlVideo ");
		sql.append("from project inner join description ");
		sql.append("on project.id_project = description.id_project ");
		sql.append("and project.project = ?;");
		return sql.toString();
	}

	@Override
	public double getCurrenMoney(String nameProject) throws GettingDateException {
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
			throw new GettingDateException();
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
		sql.append("(question, id_project) ");
		sql.append("values (?, ");
		sql.append("(select id_project ");
		sql.append("from project ");
		sql.append("where project = ?));");
		return sql.toString();
	}
}
