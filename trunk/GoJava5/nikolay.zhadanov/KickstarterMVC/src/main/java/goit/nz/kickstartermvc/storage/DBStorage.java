package goit.nz.kickstartermvc.storage;

import goit.nz.kickstartermvc.dao.Category;
import goit.nz.kickstartermvc.dao.FAQ;
import goit.nz.kickstartermvc.dao.Project;
import goit.nz.kickstartermvc.dao.ProjectEvent;
import goit.nz.kickstartermvc.dao.Quote;
import goit.nz.kickstartermvc.dao.RewardOption;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBStorage implements DataStorage {
	private static final String DB_PROPS_PATH = "props/db.properties";
	private DataSource dbSource;

	@Override
	public List<Quote> getQuotes() {
		List<Quote> result = new ArrayList<>();
		String sql = "SELECT text, author FROM quotes";
		try (Connection conn = dbSource.getConnection()) {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String quoteText = resultSet.getString("text");
				String quoteAuthor = resultSet.getString("author");
				result.add(new Quote(quoteText, quoteAuthor));
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Category> getCategories() {
		List<Category> result = new ArrayList<>();
		String sql = "SELECT id, name FROM categories";
		try (Connection conn = dbSource.getConnection()) {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String categoryName = resultSet.getString("name");
				int categoryId = resultSet.getInt("id");
				Category category = new Category(categoryName);
				category.setId(categoryId);
				result.add(category);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Project> getProjects(String chosenCategoryName) {
		List<Project> result = new ArrayList<>();
		Category foundCategory = findCategoryByName(chosenCategoryName);
		String sql = "SELECT id, name, coalesce(description, '') AS desc, amount_goal, "
				+ "amount_pledged, deadline FROM projects WHERE category_id = ? "
				+ "ORDER BY id";
		try (Connection conn = dbSource.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, foundCategory.getId());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				result.add(createInMemoryProject(foundCategory, resultSet));
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private Project createInMemoryProject(Category foundCategory,
			ResultSet resultSet) throws SQLException {
		long id = resultSet.getLong("id");
		String name = resultSet.getString("name");
		String desc = resultSet.getString("desc");
		int amountGoal = resultSet.getInt("amount_goal");
		int amountPledged = resultSet.getInt("amount_pledged");
		Date endDate = resultSet.getDate("deadline");
		if (endDate == null) {
			endDate = new Date();
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		String deadline = dateFormat.format(endDate);
		Project project = new Project(name, desc, amountGoal, amountPledged,
				deadline);
		project.setCategory(foundCategory);
		project.setId(id);
		addFaqs(project);
		addEvents(project);
		addRewards(project);
		return project;
	}

	private void addFaqs(Project project) {
		String sql = "SELECT question, coalesce(answer, '') AS answer "
				+ "FROM faqs WHERE project_id = ? ORDER BY id";
		try (Connection conn = dbSource.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, project.getId());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String question = resultSet.getString("question");
				String answer = resultSet.getString("answer");
				FAQ faq = new FAQ(question, answer);
				project.addFAQ(faq);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void addEvents(Project project) {
		String sql = "SELECT description, event_date "
				+ "FROM events WHERE project_id = ? ORDER BY event_date";
		try (Connection conn = dbSource.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, project.getId());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String desc = resultSet.getString("description");
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
				Date eventDate = resultSet.getDate("event_date");
				String date = dateFormat.format(eventDate);
				ProjectEvent event = new ProjectEvent(desc, date);
				project.addEvent(event);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void addRewards(Project project) {
		String sql = "SELECT amount, description "
				+ "FROM reward_options WHERE project_id = ? "
				+ "ORDER BY amount";
		try (Connection conn = dbSource.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, project.getId());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int amount = resultSet.getInt("amount");
				String desc = resultSet.getString("description");
				RewardOption rewardOption = new RewardOption(amount, desc);
				project.addRewardOption(rewardOption);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Category findCategoryByName(String chosenCategoryName) {
		Category found = null;
		String sql = "SELECT id, name FROM categories WHERE name = ?";
		try (Connection conn = dbSource.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, chosenCategoryName);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int categoryId = resultSet.getInt("id");
				found = new Category(chosenCategoryName);
				found.setId(categoryId);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return found;
	}

	@Override
	public void addPledgedAmount(String categoryName, int projectIndex,
			int amount) {
		Project project = getProjects(categoryName).get(projectIndex - 1);
		project.addPledgedAmount(amount);
		updatePledgedAmount(project);
	}

	private void updatePledgedAmount(Project project) {
		String sql = "UPDATE projects SET amount_pledged = ? " + "WHERE id = ?";
		try (Connection conn = dbSource.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, project.getPledgedAmount());
			statement.setLong(2, project.getId());
			statement.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addQuestion(String categoryName, int projectIndex,
			String question) {
		long projectId = getProjects(categoryName).get(projectIndex - 1)
				.getId();
		String sql = "INSERT INTO faqs (question, project_id) VALUES (?, ?)";
		try (Connection conn = dbSource.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, question);
			statement.setLong(2, projectId);
			statement.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initStorage() {
		Properties dbProps = getDBProperties();
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(dbProps.getProperty("driver"));
		dataSource.setUrl(dbProps.getProperty("url"));
		dataSource.setUsername(dbProps.getProperty("user"));
		dataSource.setPassword(dbProps.getProperty("password"));
		dataSource.setDefaultAutoCommit(false);
		dbSource = dataSource;
		try {
			checkConnection();
		} catch (SQLException e) {
			throw new RuntimeException("Problem with DB connectivity!", e);
		}
	}

	private void checkConnection() throws SQLException {
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	private Properties getDBProperties() {
		Properties props = new Properties();
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		try (InputStream input = classLoader.getResourceAsStream(DB_PROPS_PATH)) {
			props.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}

}
