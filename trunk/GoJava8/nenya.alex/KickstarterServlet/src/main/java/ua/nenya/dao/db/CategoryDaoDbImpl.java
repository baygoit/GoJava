package ua.nenya.dao.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.nenya.dao.CategoryDao;
import ua.nenya.domain.Category;
import ua.nenya.domain.Project;
import ua.nenya.domain.Question;
import ua.nenya.domain.Reward;
import ua.nenya.util.ConnectionManager;

public class CategoryDaoDbImpl implements CategoryDao {

	private static final String GET_ALL_CATEGORIES = "SELECT category_name, id FROM categories ORDER BY category_name";
	private static final String GET_PROJECTS_BY_CATEGORY_NAME = "SELECT projects.id AS id, project_name, description, all_amount, "
			+ "days_remain, history, video FROM categories INNER JOIN projects ON "
			+ "categories.id = projects.category_id WHERE category_name =? ORDER BY project_name";
	private static final String GET_AVAILABLE_AMOUNT_BY_PROJECT_ID = "SELECT Projects.id, Projects.project_name, "
			+ "SUM(Payments.amount) AS sum FROM Projects INNER JOIN Payments ON Projects.id = Payments.project_id "
			+ "GROUP BY Projects.id HAVING Projects.id = ?";
	private static final String GET_QUESTIONS_BY_PROJECT_NAME = "SELECT questions.id AS id, question FROM projects INNER JOIN questions ON "
			+ "projects.id=questions.project_id WHERE project_name =? ORDER BY id";
	private static final String GET_REWARDS_BY_PROJECT_NAME = "SELECT name, amount, rewards.description AS description FROM projects "
			+ "INNER JOIN rewards ON projects.id = rewards.project_id WHERE project_name = ?";
	private static final String WRITE_QUESTION_IN_PROJECT = "INSERT INTO Questions (project_id, question) VALUES (?,?)";
	private static final String IS_QUESTION_EXISTS = "SELECT COUNT(help.question) AS count FROM (SELECT * FROM Questions "
			+ "WHERE project_id =? ) AS help WHERE help.question = ?";
	private static final String GET_PROJECT_ID_BY_PROJECT_NAME = "SELECT id FROM projects WHERE project_name = ?";
	private static final String WRITE_INVESTMENT_IN_PROJECT = "INSERT INTO PAYMENTS (project_id, amount) VALUES (?, ?)";
	private static final String GET_PROJECT_BY_NAME = "SELECT id, project_name, description, all_amount, days_remain,"
			+ " history, video FROM projects WHERE project_name = ?";
	private ConnectionManager connectionManager;
	

	public CategoryDaoDbImpl(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	@Override
	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<Category>();
		try (PreparedStatement statement = connectionManager.getConnection().prepareStatement(GET_ALL_CATEGORIES)) {
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				Category category = new Category();
				category.setName(set.getString("category_name"));
				category.setId(set.getInt("id"));
				categories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public List<Project> getProjects(String categoryName) {
		List<Project> projects = new ArrayList<>();
		try (PreparedStatement statement = connectionManager.getConnection().prepareStatement(GET_PROJECTS_BY_CATEGORY_NAME)) {
			statement.setString(1, categoryName);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				Project project = new Project();
				fillProject(set, project);
				projects.add(project);
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return projects;
	}

	private void fillProject(ResultSet set, Project project) throws SQLException {
		String projectName = set.getString("project_name");
		String description = set.getString("description");
		int neededAmount = set.getInt("all_amount");
		int daysRemain = set.getInt("days_remain");
		String history = set.getString("history");
		String video = set.getString("video");

		project.setName(projectName);
		project.setDescription(description);
		project.setNeededAmount(neededAmount);
		project.setDaysRemain(daysRemain);
		project.setHistory(history);
		project.setVideo(video);
		
		int projectId = set.getInt("id");
		int availableAmount = getAvailableAmount(projectId);
		
		project.setAvailableAmount(availableAmount);
		
		getQuestions(projectName);
	}

	private int getAvailableAmount(int projectId) {
		int amount = 0;
		try (PreparedStatement statement = connectionManager.getConnection().prepareStatement(GET_AVAILABLE_AMOUNT_BY_PROJECT_ID)) {
			statement.setInt(1, projectId);
			ResultSet set = statement.executeQuery();
			set.next();
			amount = set.getInt("sum");
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return amount;
	}

	public List<Question> getQuestions(String projectName) {
		List<Question> questions = new ArrayList<>();
		try (PreparedStatement statement = connectionManager.getConnection().prepareStatement(GET_QUESTIONS_BY_PROJECT_NAME)) {
			statement.setString(1, projectName);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				Question question = new Question();
				String name = set.getString("question");
				question.setName(name);
				questions.add(question);
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return questions;
	}

	@Override
	public List<Reward> getRewards(String projectName) {
		List<Reward> rewards = new ArrayList<>();
		try (PreparedStatement statement = connectionManager.getConnection().prepareStatement(GET_REWARDS_BY_PROJECT_NAME)) {
			statement.setString(1, projectName);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				Reward reward = new Reward();
				String name = set.getString("name");
				int amount = set.getInt("amount");
				String description = set.getString("description");
				reward.setName(name);
				reward.setDescription(description);
				reward.setAmount(amount);
				rewards.add(reward);
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return rewards;
	}


	@Override
	public void writeQuestionInProject(String projectName, String question) {
		int id = getProjectId(projectName);
		if(question == null || question.isEmpty()){
			return;
		}
		if(isQuestionExists(projectName, question)){
			return;
		}
		try (PreparedStatement statement = connectionManager.getConnection().prepareStatement(WRITE_QUESTION_IN_PROJECT)) {
			statement.setInt(1, id);
			statement.setString(2, question);
			statement.executeQuery();
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	private boolean isQuestionExists(String projectName, String question) {
		int count = 0;
			try (PreparedStatement statement = connectionManager.getConnection().prepareStatement(IS_QUESTION_EXISTS)) {
				statement.setInt(1, getProjectId(projectName));
				statement.setString(2, question);
			ResultSet set = statement.executeQuery();
			set.next();
			count = set.getInt("count");
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return count != 0;
	}

	private int getProjectId(String projectName) {
		int id = 0;
		try (PreparedStatement statement = connectionManager.getConnection().prepareStatement(GET_PROJECT_ID_BY_PROJECT_NAME)) {
			statement.setString(1, projectName);
			ResultSet set = statement.executeQuery();
			set.next();
			id = set.getInt("id");
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return id;
	}

	@Override
	public void writeIvestmentInProject(String projectName, int amount) {
		
		int id = getProjectId(projectName);
		try (PreparedStatement statement = connectionManager.getConnection().prepareStatement(WRITE_INVESTMENT_IN_PROJECT)) {
			statement.setInt(1, id);
			statement.setInt(2, amount);
			statement.executeQuery();
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	@Override
	public Project getProjectByName(String projectName) {
		Project project = new Project();
		try (PreparedStatement statement = connectionManager.getConnection().prepareStatement(GET_PROJECT_BY_NAME)) {
			statement.setString(1, projectName); 
			ResultSet set = statement.executeQuery();
			set.next();
			fillProject(set, project);
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return project;
	}


}
