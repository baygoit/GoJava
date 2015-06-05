package kickstarter.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kickstarter.exception.CannotAddDataException;
import kickstarter.exception.CannotCreateTableException;
import kickstarter.exception.CannotGetDataException;
import kickstarter.model.engine.Project;

public class ProjectsDAOImpl implements ProjectsDAO {

	private Connection connection;

	public ProjectsDAOImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void createTableProjects() throws CannotCreateTableException {
		try {
			Statement statement = connection.createStatement();

			StringBuilder sql = new StringBuilder();
			sql.append("drop table IF EXISTS Projects; ");
			sql.append("create table Projects (");
			sql.append("id serial not null PRIMARY KEY, ");
			sql.append("id_category integer, ");
			sql.append("name varchar(255), ");
			sql.append("description varchar(255), ");
			sql.append("totalAmount integer, ");
			sql.append("daysLeft integer, ");
			sql.append("collectAmount integer, ");
			sql.append("history varchar(255), ");
			sql.append("link varchar(255), ");
			sql.append("questionsAndAnswers varchar(255)");
			sql.append("); ");
			sql.append("alter table Projects ");
			sql.append("add FOREIGN KEY (id_category) ");
			sql.append("REFERENCES categories(id)");

			statement.execute(sql.toString());

		} catch (SQLException e) {
			throw new CannotCreateTableException(e);
		}
	}

	@Override
	public void addProject(int categoryId, String name, String description, int totalAmount, int daysLeft,
			String history, String link) throws CannotAddDataException {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("insert into Projects (");
			sql.append("id_category, name, description, ");
			sql.append("totalAmount, daysLeft, collectAmount, ");
			sql.append("history, link, questionsAndAnswers");
			sql.append(") ");
			sql.append("values(?,?,?,?,?,?,?,?,?)");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setInt(1, categoryId);
			statement.setString(2, name);
			statement.setString(3, description);
			statement.setInt(4, totalAmount);
			statement.setInt(5, daysLeft);
			statement.setInt(6, 0);
			statement.setString(7, history);
			statement.setString(8, link);
			statement.setString(9, "");

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new CannotAddDataException(e);
		}
	}

	@Override
	public List<Project> getProjects(int categoryId) throws CannotGetDataException {
		List<Project> result = new ArrayList<>();

		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select id, id_category, name, description, ");
			sql.append("totalAmount, daysLeft, collectAmount, ");
			sql.append("history, link, questionsAndAnswers ");
			sql.append("from Projects ");
			sql.append("where id_category = ?");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setInt(1, categoryId);

			ResultSet resultQuery = statement.executeQuery();
			while (resultQuery.next()) {
				result.add(getProject(resultQuery));
			}
		} catch (SQLException e) {
			throw new CannotGetDataException(e);
		}
		return result;
	}

	@Override
	public Project getProject(int id, int categoryId) throws CannotGetDataException {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select id, id_category, name, description, ");
			sql.append("totalAmount, daysLeft, collectAmount, ");
			sql.append("history, link, questionsAndAnswers ");
			sql.append("from Projects ");
			sql.append("where id = ? ");
			sql.append("AND ");
			sql.append("id_category = ?");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setInt(1, id);
			statement.setInt(2, categoryId);

			ResultSet resultQuery = statement.executeQuery();

			if (resultQuery.next()) {
				return getProject(resultQuery);
			} else {
				throw new CannotGetDataException("no existing data");
			}
		} catch (SQLException e) {
			throw new CannotGetDataException(e);
		}
	}

	private Project getProject(ResultSet resultQuery) throws SQLException {
		int id = resultQuery.getInt("id");
		int categoryId = resultQuery.getInt("id_category");
		String name = resultQuery.getString("name");
		String description = resultQuery.getString("description");
		int totalAmount = resultQuery.getInt("totalAmount");
		int daysLeft = resultQuery.getInt("daysLeft");
		String history = resultQuery.getString("history");
		String link = resultQuery.getString("link");
		String questionsAndAnswers = resultQuery.getString("questionsAndAnswers");
		int collectAmount = resultQuery.getInt("collectAmount");

		return new Project(id, categoryId, name, description, totalAmount, daysLeft, history, link,
				questionsAndAnswers, collectAmount);
	}
}
