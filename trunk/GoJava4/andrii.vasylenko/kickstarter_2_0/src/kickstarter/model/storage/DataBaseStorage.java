package kickstarter.model.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kickstarter.exception.CannotAddDataException;
import kickstarter.exception.CannotCreateTableException;
import kickstarter.exception.CannotGetDataException;
import kickstarter.model.engine.Category;
import kickstarter.model.engine.Project;
import kickstarter.model.engine.Quote;

public class DataBaseStorage implements Storage {
	public static final String SQL_URL = "jdbc:postgresql://localhost:5433/kickstarter";
	public static final String SQL_USER = "postgres";
	public static final String SQL_PASSWORD = "111";

	@Override
	public void addQuote(Quote quote) throws CannotAddDataException {
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement statement = connection.prepareStatement("insert into quotes (quote) values(?)");
			setQuoteFields(statement, quote);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CannotAddDataException(e);
		}
	}

	@Override
	public Quote getRandomQuote() throws CannotGetDataException {
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select id, quote from quotes order by random() limit 1");
			while (result.next()) {
				return getQuote(result);
			}
		} catch (SQLException e) {
			throw new CannotGetDataException(e);
		}
		throw new CannotGetDataException("no existing data");
	}

	@Override
	public void addCategory(Category category) throws CannotAddDataException {
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement statement = connection.prepareStatement("insert into categories (name) values(?)");
			setCategoryFields(statement, category);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CannotAddDataException(e);
		}
	}

	@Override
	public List<Category> getCategories() throws CannotGetDataException {
		List<Category> result = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			Statement statement = connection.createStatement();
			ResultSet resultQuery = statement.executeQuery("select id, name from categories");
			while (resultQuery.next()) {
				result.add(getCategory(resultQuery));
			}
		} catch (SQLException e) {
			throw new CannotGetDataException(e);
		}
		return result;
	}

	@Override
	public Category getCategory(int id) throws CannotGetDataException {
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement statement = connection.prepareStatement("select id, name from categories where id = ?");
			statement.setInt(1, id);
			ResultSet resultQuery = statement.executeQuery();
			while (resultQuery.next()) {
				return getCategory(resultQuery);
			}
		} catch (SQLException e) {
			throw new CannotGetDataException(e);
		}
		throw new CannotGetDataException("no existing data");
	}

	@Override
	public void addProject(Project project, Category category) throws CannotAddDataException {
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement statement = connection.prepareStatement("insert into projects ("
					+ "id_category, name, description, totalAmount, daysLeft, collectAmount, "
					+ "history, link, questionsAndAnswers) values(?,?,?,?,?,?,?,?,?)");
			int categoryId = getCategoryIdByName(category, connection);
			setProjectFields(statement, project, categoryId);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CannotAddDataException(e);
		}
	}

	@Override
	public List<Project> getProjects(Category category) throws CannotGetDataException {
		List<Project> result = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement statement = connection
					.prepareStatement("select id, name, description, totalAmount, daysLeft, "
							+ "collectAmount, history, link, questionsAndAnswers from projects "
							+ "where id_category = ?");
			statement.setInt(1, category.getId());
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
	public Project getProject(int id, Category category) throws CannotGetDataException {
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			PreparedStatement statement = connection
					.prepareStatement("select id, name, description, totalAmount, daysLeft, "
							+ "collectAmount, history, link, questionsAndAnswers from projects where id = ? AND id_category = ?");
			statement.setInt(1, id);
			statement.setInt(2, category.getId());
			ResultSet resultQuery = statement.executeQuery();
			while (resultQuery.next()) {
				return getProject(resultQuery);
			}
		} catch (SQLException e) {
			throw new CannotGetDataException(e);
		}
		throw new CannotGetDataException("no existing data");
	}

	public void createTableQuotes() throws CannotCreateTableException {
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			Statement statement = connection.createStatement();
			statement.execute("create table quotes (id SERIAL not null PRIMARY KEY, quote varchar(255))");
		} catch (SQLException e) {
			throw new CannotCreateTableException(e);
		}
	}

	public void createTableCategories() throws CannotCreateTableException {
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			Statement statement = connection.createStatement();
			statement.execute("create table categories (id SERIAL not null PRIMARY KEY, name varchar(255))");
		} catch (SQLException e) {
			throw new CannotCreateTableException(e);
		}
	}

	public void createTableProjects() throws CannotCreateTableException {
		try (Connection connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASSWORD)) {
			Statement statement = connection.createStatement();
			statement.execute("create table projects (id SERIAL not null PRIMARY KEY, id_category integer,"
					+ "name varchar(255), description varchar(255), "
					+ "totalAmount integer, daysLeft integer, collectAmount integer, "
					+ "history varchar(255), link varchar(255), questionsAndAnswers varchar(255));"
					+ "ALTER TABLE projects ADD FOREIGN KEY (id_category) REFERENCES categories(id)");
		} catch (SQLException e) {
			throw new CannotCreateTableException(e);
		}
	}

	private int getCategoryIdByName(Category category, Connection connection) throws SQLException,
			CannotAddDataException {
		PreparedStatement statement = connection.prepareStatement("select id from categories where name = ?");
		setCategoryFields(statement, category);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			return result.getInt("id");
		}
		throw new CannotAddDataException("no chosen category");
	}

	private void setQuoteFields(PreparedStatement statement, Quote quote) throws SQLException {
		statement.setString(1, quote.getQuote());
	}

	private Quote getQuote(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String qoute = result.getString("quote");

		return new Quote(id, qoute);
	}

	private void setCategoryFields(PreparedStatement statement, Category category) throws SQLException {
		statement.setString(1, category.getName());
	}

	private Category getCategory(ResultSet resultQuery) throws SQLException {
		int id = resultQuery.getInt("id");
		String name = resultQuery.getString("name");

		return new Category(id, name);
	}

	private void setProjectFields(PreparedStatement statement, Project project, int categoryId) throws SQLException {
		statement.setInt(1, categoryId);
		statement.setString(2, project.getName());
		statement.setString(3, project.getDescription());
		statement.setInt(4, project.getTotalAmount());
		statement.setInt(5, project.getDaysLeft());
		statement.setInt(6, project.getCollectAmount());
		statement.setString(7, project.getHistory());
		statement.setString(8, project.getLink());
		statement.setString(9, project.getQuestionsAndAnswers());
	}

	private Project getProject(ResultSet resultQuery) throws SQLException {
		int id = resultQuery.getInt("id");
		String name = resultQuery.getString("name");
		String description = resultQuery.getString("description");
		int totalAmount = resultQuery.getInt("totalAmount");
		int daysLeft = resultQuery.getInt("daysLeft");
		String history = resultQuery.getString("history");
		String link = resultQuery.getString("link");
		String questionsAndAnswers = resultQuery.getString("questionsAndAnswers");
		int collectAmount = resultQuery.getInt("collectAmount");

		return new Project(id, name, description, totalAmount, daysLeft, history, link, questionsAndAnswers,
				collectAmount);
	}
}
