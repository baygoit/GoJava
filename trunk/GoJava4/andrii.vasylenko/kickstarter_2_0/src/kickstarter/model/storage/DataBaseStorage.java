package kickstarter.model.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kickstarter.model.engine.Category;
import kickstarter.model.engine.Project;
import kickstarter.model.engine.Quote;

public class DataBaseStorage implements Storage {
	public static final String SQL_URL = "jdbc:postgresql://localhost:5433/kickstarter";
	public static final String SQL_USER = "postgres";
	public static final String SQL_PASSWORD = "111";

	@Override
	public void addQuote(Quote quote) {
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement statement = connection.prepareStatement("insert into quotes (quote) values(?)");
			statement.setString(1, quote.getQuote());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Quote getRandomQuote() {
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select id, quote from quotes order by random() limit 1");
			while (result.next()) {
				return new Quote(result.getInt("id"), result.getString("quote"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		throw new RuntimeException();
	}

	@Override
	public void addCategory(Category category) {
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement statement = connection.prepareStatement("insert into categories (name) values(?)");
			statement.setString(1, category.getName());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Category> getCategories() {
		List<Category> result = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			Statement statement = connection.createStatement();
			ResultSet resultQuery = statement.executeQuery("select id, name from categories");
			while (resultQuery.next()) {
				result.add(new Category(resultQuery.getInt("id"), resultQuery.getString("name")));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	@Override
	public Category getCategory(int id) {
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement statement = connection.prepareStatement("select id, name from categories where id = ?");
			statement.setInt(1, id);
			ResultSet resultQuery = statement.executeQuery();
			while (resultQuery.next()) {
				return new Category(resultQuery.getInt("id"), resultQuery.getString("name"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		throw new RuntimeException();
	}

	@Override
	public void addProject(Project project, Category category) {
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement statement = connection.prepareStatement("insert into projects ("
					+ "id_category, name, description, totalAmount, daysLeft, collectAmount, "
					+ "history, link, questionsAndAnswers) values(?,?,?,?,?,?,?,?,?)");
			statement.setInt(1, getCategoryIdByName(category, connection));
			statement.setString(2, project.getName());
			statement.setString(3, project.getDescription());
			statement.setInt(4, project.getTotalAmount());
			statement.setInt(5, project.getDaysLeft());
			statement.setInt(6, project.getCollectAmount());
			statement.setString(7, project.getHistory());
			statement.setString(8, project.getLink());
			statement.setString(9, project.getQuestionsAndAnswers());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Project> getProjects(Category category) {
		List<Project> result = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement statement = connection
					.prepareStatement("select id, name, description, totalAmount, daysLeft, "
							+ "collectAmount, history, link, questionsAndAnswers from projects "
							+ "where id_category = ?");
			statement.setInt(1, category.getId());
			ResultSet resultQuery = statement.executeQuery();
			while (resultQuery.next()) {
				result.add(new Project(resultQuery.getInt("id"), resultQuery.getString("name"), resultQuery
						.getString("description"), resultQuery.getInt("totalAmount"), resultQuery.getInt("daysLeft"),
						resultQuery.getString("history"), resultQuery.getString("link"), resultQuery
								.getString("questionsAndAnswers"), resultQuery.getInt("collectAmount")));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;

	}

	@Override
	public Project getProject(int id, Category category) {
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement statement = connection
					.prepareStatement("select id, name, description, totalAmount, daysLeft, "
							+ "collectAmount, history, link, questionsAndAnswers from projects where id = ? AND id_category = ?");
			statement.setInt(1, id);
			statement.setInt(2, category.getId());
			ResultSet resultQuery = statement.executeQuery();
			while (resultQuery.next()) {
				return new Project(resultQuery.getInt("id"), resultQuery.getString("name"),
						resultQuery.getString("description"), resultQuery.getInt("totalAmount"),
						resultQuery.getInt("daysLeft"), resultQuery.getString("history"),
						resultQuery.getString("link"), resultQuery.getString("questionsAndAnswers"),
						resultQuery.getInt("collectAmount"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		throw new RuntimeException();
	}

	public void createTableQuotes() {
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			Statement statement = connection.createStatement();
			statement.execute("create table quotes (id SERIAL not null PRIMARY KEY, quote varchar(255))");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void createTableCategories() {
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			Statement statement = connection.createStatement();
			statement.execute("create table categories (id SERIAL not null PRIMARY KEY, name varchar(255))");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void createTableProjects() {
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			Statement statement = connection.createStatement();
			statement.execute("create table projects (id SERIAL not null PRIMARY KEY, id_category integer,"
					+ "name varchar(255), description varchar(255), "
					+ "totalAmount integer, daysLeft integer, collectAmount integer, "
					+ "history varchar(255), link varchar(255), questionsAndAnswers varchar(255));"
					+ "ALTER TABLE projects ADD FOREIGN KEY (id_category) REFERENCES categories(id)");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private int getCategoryIdByName(Category category, Connection connection) throws SQLException {
		PreparedStatement statement = connection.prepareStatement("select id from categories where name = ?");
		statement.setString(1, category.getName());
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			return result.getInt("id");
		}
		throw new RuntimeException();
	}
}
