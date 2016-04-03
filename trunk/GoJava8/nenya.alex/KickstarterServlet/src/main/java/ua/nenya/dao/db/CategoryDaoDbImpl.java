package ua.nenya.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.nenya.dao.CategoryDao;
import ua.nenya.project.Category;
import ua.nenya.project.Project;
import ua.nenya.project.Question;
import ua.nenya.project.Reward;
import ua.nenya.util.ConnectionManager;

public class CategoryDaoDbImpl implements CategoryDao {

	private ConnectionManager connectionManager;
	

	public CategoryDaoDbImpl(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	@Override
	public List<Category> initCategories() {
		List<Category> categories = new ArrayList<Category>();
		String query = "SELECT category_name, id FROM categories ORDER BY category_name";
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet set = statement.executeQuery(query);
			while (set.next()) {
				Category category = new Category();
				category.setName(set.getString("category_name"));
				category.setId(set.getInt("id"));
				categories.add(category);
			}
			set.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public List<Project> initProjects(Category category) {
		List<Project> projects = new ArrayList<>();
		String query = "SELECT projects.id AS id, project_name, description, all_amount, days_remain,"
				+ " history, video FROM categories INNER JOIN projects ON "
				+ "categories.id = projects.category_id WHERE category_name = '" + category.getName() + "' ORDER BY project_name";
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet set = statement.executeQuery(query);
			while (set.next()) {
				Project project = new Project();
				fillProject(set, project);
				projects.add(project);
			}
			set.close();
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return projects;
	}

	private void fillProject(ResultSet set, Project project) throws SQLException {
		String name = set.getString("project_name");
		String description = set.getString("description");
		int neededAmount = set.getInt("all_amount");
		int daysRemain = set.getInt("days_remain");
		String history = set.getString("history");
		String video = set.getString("video");

		project.setName(name);
		project.setDescription(description);
		project.setNeededAmount(neededAmount);
		project.setDaysRemain(daysRemain);
		project.setHistory(history);
		project.setVideo(video);
		
		int projectId = set.getInt("id");
		int availableAmount = getAvailableAmount(projectId);
		
		project.setAvailableAmount(availableAmount);
		
		initQuestions(project);
	}

	private int getAvailableAmount(int projectId) {
		int amount = 0;
		String query = "SELECT Projects.id, Projects.project_name, SUM(Payments.amount) AS sum "
				+ "FROM Projects INNER JOIN Payments ON Projects.id = Payments.project_id "
				+ "GROUP BY Projects.id HAVING Projects.id = " + projectId + ";";
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet set = statement.executeQuery(query);
			set.next();
			amount = set.getInt("sum");
			set.close();
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return amount;
	}

	public List<Question> initQuestions(Project project) {
		List<Question> questions = new ArrayList<>();
		String query = "SELECT questions.id AS id, question FROM projects INNER JOIN questions ON "
				+ "projects.id=questions.project_id WHERE project_name = '" + project.getName()+ "' ORDER BY id";
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet set = statement.executeQuery(query);
			while (set.next()) {
				Question question = new Question();
				String name = set.getString("question");
				question.setName(name);
				questions.add(question);
			}
			set.close();
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return questions;
	}

	@Override
	public List<Reward> initRewards(Project project) {
		List<Reward> rewards = new ArrayList<>();
		String query = "SELECT name, amount, rewards.description AS description FROM projects "
				+ "INNER JOIN rewards ON projects.id = rewards.project_id " + "WHERE project_name = '" + project.getName()
				+ "'";
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet set = statement.executeQuery(query);
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
			set.close();
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
		String query = "INSERT INTO Questions (project_id, question) VALUES (" + id + ", '" + question + "');";
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet set = statement.executeQuery(query);
			set.close();
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	private boolean isQuestionExists(String projectName, String question) {
		String query = "SELECT COUNT(help.question) AS count FROM "
				+ "(SELECT * FROM Questions WHERE project_id = "+getProjectId(projectName)+
				") AS help WHERE help.question = '"+question+"' ;";
		int count = 0;
			try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet set = statement.executeQuery(query);
			set.next();
			count = set.getInt("count");
			set.close();
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return count != 0;
	}

	private int getProjectId(String projectName) {
		String query = "SELECT id FROM projects WHERE project_name = '" + projectName+ "'";
		int id = 0;
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet set = statement.executeQuery(query);
			set.next();
			id = set.getInt("id");
			set.close();
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return id;
	}

	@Override
	public void writeIvestmentInProject(String projectName, int amount) {
		
		int id = getProjectId(projectName);
		
		String query = "INSERT INTO PAYMENTS (project_id, amount) VALUES ("+id+", "+amount+")";
		
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet set = statement.executeQuery(query);
			set.close();
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	@Override
	public Project getProjectByName(String projectName) {
		Project project = new Project();
		String query = "SELECT id, project_name, description, all_amount, days_remain,"
				+ " history, video FROM projects WHERE project_name = '" + projectName + "';";
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet set = statement.executeQuery(query);
			set.next();
			fillProject(set, project);
			set.close();
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return project;
	}


}
