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
		String query = "SELECT category_name FROM categories ORDER BY category_name";
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet set = statement.executeQuery(query);
			while (set.next()) {
				Category category = new Category();
				category.setName(set.getString("category_name"));
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
		String query = "SELECT project_name, description, all_amount, available_amount, days_remain,"
				+ " history, video FROM categories INNER JOIN projects ON "
				+ "categories.id = projects.category_id WHERE category_name = '" + category.getName() + "' ORDER BY project_name";
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet set = statement.executeQuery(query);
			while (set.next()) {
				Project project = new Project();
				String name = set.getString("project_name");
				String description = set.getString("description");
				int neededAmount = set.getInt("all_amount");
				int availableAmount = set.getInt("available_amount");
				int daysRemain = set.getInt("days_remain");
				String history = set.getString("history");
				String video = set.getString("video");

				project.setName(name);
				project.setDescription(description);
				project.setAvailableAmount(availableAmount);
				project.setNeededAmount(neededAmount);
				project.setDaysRemain(daysRemain);
				project.setHistory(history);
				project.setVideo(video);
				initQuestions(project);
				projects.add(project);
			}
			set.close();
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return projects;
	}

	public List<Question> initQuestions(Project project) {
		List<Question> questions = new ArrayList<>();
		String query = "SELECT question FROM projects INNER JOIN questions ON "
				+ "projects.id=questions.project_id WHERE project_name = '" + project.getName()+ "'";
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
		addAnyAmountReward(rewards);
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

	private void addAnyAmountReward(List<Reward> rewards) {
		Reward anyAmountReward = new Reward();
		anyAmountReward.setName("Any amount");
		anyAmountReward.setDescription("");
		rewards.add(anyAmountReward);
	}


	@Override
	public void writeQuestionInProject(Project project, Question question) {
		int id = getProjectId(project);
		String query = "INSERT INTO Questions (project_id, question) VALUES ("+ id+ ", '"+question.getName()+"');";
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet set = statement.executeQuery(query);
			set.close();
		} catch (SQLException e) {
			e.getStackTrace();
		}
		
	}

	private int getProjectId(Project project) {
		String query = "SELECT id FROM projects WHERE project_name = '" + project.getName()+ "'";
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
	public void writeIvestmentInProject(Project project, int amount) {
		
		int previousAmount = project.getAvailableAmount();
		int newAmount = previousAmount + amount;	
		
		String query = "UPDATE Projects SET available_amount = "
		+ newAmount+ " WHERE project_name = '"+ project.getName()+"';";
		
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet set = statement.executeQuery(query);
			set.close();
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

}
