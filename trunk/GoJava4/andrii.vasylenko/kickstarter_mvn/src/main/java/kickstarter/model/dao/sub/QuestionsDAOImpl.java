package kickstarter.model.dao.sub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import kickstarter.model.dao.connection.ConnectionPool;

public class QuestionsDAOImpl implements QuestionsDAO {
	private ConnectionPool connectionPool;

	public QuestionsDAOImpl(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}

	@Override
	public void addQuestion(int projectId, String question) throws SQLException {
		try (Connection connection = connectionPool.getConnection()) {
			String sql = getInsertQuery();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, projectId);
			statement.setString(2, question);

			statement.executeUpdate();
		}
	}

	@Override
	public void createTableQuestions() throws SQLException {
		try (Connection connection = connectionPool.getConnection()) {
			Statement statement = connection.createStatement();
			String sql = getCreateQuery();
			statement.execute(sql);
		}
	}

	private String getInsertQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into Questions (");
		sql.append("id_project, question");
		sql.append(") ");
		sql.append("values(?,?)");
		return sql.toString();
	}

	private String getCreateQuery() {
		StringBuilder sql = new StringBuilder();

		sql.append("drop table IF EXISTS Questions; ");

		sql.append("create table Questions (");
		sql.append("id serial not null PRIMARY KEY, ");
		sql.append("id_project integer, ");
		sql.append("question varchar(255)");
		sql.append("); ");

		sql.append("alter table Questions ");
		sql.append("add FOREIGN KEY (id_project) ");
		sql.append("REFERENCES Projects(id); ");
		return sql.toString();
	}
}
