package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.models.Category;
import ua.com.goit.gojava7.kickstarter.models.Project;
import ua.com.goit.gojava7.kickstarter.models.Question;
import ua.com.goit.gojava7.kickstarter.models.Quote;
import ua.com.goit.gojava7.kickstarter.models.Reward;

@Component
public class DbManager {

	private static final Logger log = LoggerFactory.getLogger(DbManager.class);

	@Autowired
	protected BasicDataSource basicDataSource;

	public DbManager() {
		log.info("Constructor DbManager()...");
	}

	public Quote getQuote(String query) {
		log.info("<Quote> getQuote({})...", query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				return readQuote(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Quote readQuote(ResultSet resultSet) throws SQLException {
		log.info("<Quote> readQuote()...");
		Quote quote = new Quote();
		quote.setText(resultSet.getString("text"));
		quote.setAuthor(resultSet.getString("author"));
		log.debug("readQuote() returned quote: {}", quote);
		return quote;
	}

	public List<Category> getCategories(String query) {
		log.info("<categories> getCategories({})...", query);
		List<Category> data = new ArrayList<>();
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				data.add(readCategory(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.debug("getCategories() returned categories: {}", data);
		return data;
	}

	public Category getCategory(String query) {
		log.info("<Category> getCategory({})...", query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				return readCategory(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Category readCategory(ResultSet resultSet) throws SQLException {
		log.info("<Category> readCategory()...");
		Category category = new Category();
		category.setId(resultSet.getInt("id"));
		category.setName(resultSet.getString("name"));
		log.debug("readCategory() returned category: {}", category);
		return category;
	}

	public List<Project> getProjects(String query) {
		log.info("<projects> getProjects({})...", query);
		List<Project> data = new ArrayList<>();
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				data.add(readProject(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.debug("getProjects() returned projects: {}", data);
		return data;
	}

	public Project getProject(String query) {
		log.info("<Project> getProject({})...", query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				return readProject(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updatePledged(Project project, String query) {
		log.info("<void> updatePledged({}, {})...", project, query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Project readProject(ResultSet resultSet) throws SQLException {
		log.info("<Project> readProject()...");
		Project project = new Project();
		project.setId(resultSet.getInt("id"));
		project.setName(resultSet.getString("name"));
		project.setDescription(resultSet.getString("description"));
		project.setGoal(resultSet.getInt("goal"));
		project.setPledged(resultSet.getInt("pledged"));
		project.setDaysToGo(resultSet.getInt("daysToGo"));
		project.setHistory(resultSet.getString("history"));
		project.setLink(resultSet.getString("link"));
		project.setCategoryId(resultSet.getInt("category_id"));
		log.debug("readProject() returned project: {}", project);
		return project;
	}

	public List<Reward> getRewardsByProject(String query) {
		log.info("<rewards> getRewardsByProject({})...", query);
		List<Reward> data = new ArrayList<>();
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				data.add(readReward(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.debug("getRewardsByProject() returned rewards: {}", data);
		return data;
	}

	public Reward getReward(String query) {
		log.info("<Reward> get({})...", query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				return readReward(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Reward readReward(ResultSet resultSet) throws SQLException {
		log.info("<Reward> readReward()...");
		Reward reward = new Reward();
		reward.setId(resultSet.getInt("id"));
		reward.setAmount(resultSet.getInt("amount"));
		reward.setReward(resultSet.getString("reward"));
		reward.setProjectId(resultSet.getInt("project_id"));
		log.debug("readReward() returned reward: {}", reward);
		return reward;
	}

	public void addQuestion(Question element, String query) {
		log.info("<void> addQuestion({}, {})...", element, query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			writeElement(element, ps);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void writeElement(Question question, PreparedStatement statement) throws SQLException {
		log.info("<void> writeElement({})...", question);
		statement.setString(1, question.getTime());
		statement.setString(2, question.getQuestion());
		statement.setString(3, question.getAnswer());
		statement.setInt(4, question.getProjectId());
	}

	public List<Question> getQuestionsByProject(String query) {
		log.info("<questions> getQuestionsByProject({})...", query);
		List<Question> data = new ArrayList<>();
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				data.add(readQuestion(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.debug("getQuestionsByProject() returned questions: {}", data);
		return data;
	}

	private Question readQuestion(ResultSet resultSet) throws SQLException {
		log.info("<Question> readQuestion()...");
		Question question = new Question();
		question.setTime(resultSet.getString("time"));
		question.setQuestion(resultSet.getString("question"));
		question.setAnswer(resultSet.getString("answer"));
		log.debug("readQuestion() returned question: {}", question);
		return question;
	}
}
