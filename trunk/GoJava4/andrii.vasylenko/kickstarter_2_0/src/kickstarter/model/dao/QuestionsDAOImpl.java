package kickstarter.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import kickstarter.exception.CannotAddDataException;
import kickstarter.exception.CannotCreateTableException;

public class QuestionsDAOImpl implements QuestionsDAO {
	private Connection connection;

	public QuestionsDAOImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void addQuestion(int projectId, String question) throws CannotAddDataException {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("insert into Questions (");
			sql.append("id_project, question");
			sql.append(") ");
			sql.append("values(?,?)");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setInt(1, projectId);
			statement.setString(2, question);

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new CannotAddDataException(e);
		}
	}

	@Override
	public void createTableQuestions() throws CannotCreateTableException {
		try {
			Statement statement = connection.createStatement();

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

			statement.execute(sql.toString());

		} catch (SQLException e) {
			throw new CannotCreateTableException(e);
		}
	}
}
