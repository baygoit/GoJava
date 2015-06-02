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
	public Category getCategory(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProject(Project project, Category category) {
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement statement = connection.prepareStatement("insert into projects ("
					+ "id_category, name, description, totalAmount, daysLeft, collectAmount, "
					+ "history, link, questionsAndAnswers) values(?,?,?,?,?,?,?,?,?)");
			statement.setInt(1, getCategoryId(category, connection));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project getProject(int index, Category category) {
		// TODO Auto-generated method stub
		return null;
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

	private int getCategoryId(Category category, Connection connection) throws SQLException {
		PreparedStatement statement = connection.prepareStatement("select id from categories where name = ?");
		statement.setString(1, category.getName());
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			return result.getInt("id");
		}
		throw new RuntimeException();
	}
}
