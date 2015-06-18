package kickstarter.model.dao.sub;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kickstarter.exception.DataBaseException;
import kickstarter.model.dao.connection.ConnectionPool;
import kickstarter.model.entity.Project;

public class ProjectsDAOImpl implements ProjectsDAO {
	private ConnectionPool connectionPool;

	public ProjectsDAOImpl(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}

	@Override
	public void addProject(int categoryId, String name, String description, int totalAmount, int daysLeft,
			String history, String link) throws SQLException {
		try (Connection connection = connectionPool.getConnection()) {
			String sql = getInsertQuery();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, categoryId);
			statement.setString(2, name);
			statement.setString(3, description);
			statement.setInt(4, totalAmount);
			statement.setInt(5, daysLeft);
			statement.setInt(6, 0);
			statement.setString(7, history);
			statement.setString(8, link);

			statement.executeUpdate();
		}
	}

	@Override
	public List<Project> getProjects(int categoryId) throws SQLException {
		try (Connection connection = connectionPool.getConnection()) {
			List<Project> result = new ArrayList<>();

			String sql = getMultiSelectQuery();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, categoryId);

			ResultSet resultQuery = statement.executeQuery();

			while (resultQuery.next()) {
				result.add(getProject(resultQuery, false));
			}

			return result;
		}
	}

	@Override
	public Project getProject(int id, int categoryId) throws DataBaseException, SQLException {
		try (Connection connection = connectionPool.getConnection()) {
			String sql = getSelectQuery();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, id);
			statement.setInt(2, categoryId);

			ResultSet resultQuery = statement.executeQuery();

			if (resultQuery.next()) {
				return getProject(resultQuery, true);
			} else {
				throw new DataBaseException(String.format("no Project where id = %d id_category = %d", id, categoryId));
			}
		}
	}

	@Override
	public void createTableProjects() throws SQLException {
		try (Connection connection = connectionPool.getConnection()) {
			Statement statement = connection.createStatement();
			String sql = getCreateQuery();
			statement.execute(sql);
		}
	}

	private Project getProject(ResultSet resultQuery, boolean withQuestions) throws SQLException {
		int id = resultQuery.getInt("id");
		int categoryId = resultQuery.getInt("id_category");
		String name = resultQuery.getString("name");
		String description = resultQuery.getString("description");
		int totalAmount = resultQuery.getInt("total_amount");
		int collectAmount = resultQuery.getInt("collect_amount");
		int daysLeft = resultQuery.getInt("days_left");
		String history = resultQuery.getString("history");
		String link = resultQuery.getString("link");
		List<String> questionsAndAnswers = new ArrayList<>();
		if (withQuestions) {
			questionsAndAnswers.addAll(getQuestionsList(resultQuery.getArray("questions")));
		}

		return new Project(id, categoryId, name, description, totalAmount, daysLeft, history, link,
				questionsAndAnswers, collectAmount);
	}

	private List<String> getQuestionsList(Array array) throws SQLException {
		List<String> result = new ArrayList<>();

		String[] questions = (String[]) array.getArray();
		for (String string : questions) {
			if (string != null) {
				result.add(string);
			}
		}

		return result;
	}

	private String getInsertQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into Projects (");
		sql.append("id_category, name, description, ");
		sql.append("total_amount, days_left, collect_amount, ");
		sql.append("history, link");
		sql.append(") ");
		sql.append("values(?,?,?,?,?,?,?,?)");
		return sql.toString();
	}

	private String getMultiSelectQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, id_category, name, description, ");
		sql.append("total_amount, days_left, collect_amount, ");
		sql.append("history, link ");
		sql.append("from Projects ");
		sql.append("where id_category = ?");
		return sql.toString();
	}

	private String getSelectQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("select ");
		sql.append("P.id AS id, P.id_category AS id_category, ");
		sql.append("P.name AS name, P.description AS description, ");
		sql.append("P.total_amount AS total_amount, P.days_left AS days_left, ");
		sql.append("P.collect_amount AS collect_amount, ");
		sql.append("P.history AS history, P.link AS link, ");
		sql.append("array_agg(Q.question) AS questions ");

		sql.append("from Projects P ");
		sql.append("left outer join Questions Q ");
		sql.append("on P.id = Q.id_project ");

		sql.append("where P.id = ? ");
		sql.append("AND ");
		sql.append("P.id_category = ? ");

		sql.append("group by ");
		sql.append("P.id, P.id_category, ");
		sql.append("P.name, P.description, ");
		sql.append("P.total_amount, P.days_left, ");
		sql.append("P.collect_amount, ");
		sql.append("P.history, P.link");
		return sql.toString();
	}

	private String getCreateQuery() {
		StringBuilder sql = new StringBuilder();

		sql.append("drop table IF EXISTS Projects CASCADE; ");

		sql.append("create table Projects (");
		sql.append("id serial not null PRIMARY KEY, ");
		sql.append("id_category integer, ");
		sql.append("name varchar(255), ");
		sql.append("description varchar(255), ");
		sql.append("total_amount integer, ");
		sql.append("days_left integer, ");
		sql.append("collect_amount integer, ");
		sql.append("history varchar(255), ");
		sql.append("link varchar(255)");
		sql.append("); ");

		sql.append("alter table Projects ");
		sql.append("add FOREIGN KEY (id_category) ");
		sql.append("REFERENCES Categories(id); ");
		return sql.toString();
	}
}
