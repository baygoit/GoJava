package ua.nenya.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.nenya.dao.CategoryDao;
import ua.nenya.project.Category;
import ua.nenya.project.Project;
import ua.nenya.project.Reward;
import ua.nenya.util.ConnectionManager;

public class CategoryDaoDbImpl implements CategoryDao {

	private ConnectionManager connectionManager;
	private List<Category> categories = new ArrayList<Category>();

	public CategoryDaoDbImpl(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	@Override
	public void initCategories() {
		String query = "SELECT * FROM categories";
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet set = statement.executeQuery(query);
			while(set.next()){
				Category category = new Category(set.getString("category_name"));
				if(category != null){
					addProjectsToCategory(category);
					categories.add(category);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void addProjectsToCategory(Category category) {
		String query = "SELECT * FROM categories INNER JOIN projects ON categories.id = projects.id_link";
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet set = statement.executeQuery(query);
			while(set.next()){
				Project project = null;
				if(category.getName().equals(set.getString("category_name"))){
					String name = set.getString("project_name");
					String description = set.getString("description");
					int allAmount = set.getInt("all_amount");
					int availableAmount = set.getInt("available_amount");
					int daysRemain = set.getInt("days_remain");
					String history = set.getString("history");
					String video = set.getString("video");
					String questionAnswer = set.getString("question");
					project = new Project(name, description, allAmount,
							availableAmount, daysRemain);
					project.setHistory(history);  
					project.setVideo(video);
					project.setQuestionAnswer(questionAnswer);
					addRewardsToProject(project);
				}
				
				if(project != null){
					category.getProjects().add(project);
				}
			}
		}catch (SQLException e){
			e.getStackTrace();
		}
	}
	
	private void addRewardsToProject(Project project) {
		String query = "SELECT project_name, name, amount, rewards.description AS description FROM projects INNER JOIN rewards ON projects.id = rewards.id_link";
		try (Statement statement = connectionManager.getConnection().createStatement()) {
			ResultSet set = statement.executeQuery(query);
			while(set.next()){
				Reward reward= null;
				if(project.getName().equals(set.getString("project_name"))){
					String name = set.getString("name");
					int amount = set.getInt("amount");
					String description = set.getString("description");
					reward = new Reward(name, description);
					reward.setAmount(amount);
				}
				
				if(reward != null){
					project.getRewards().add(reward);
				}
			}
		}catch (SQLException e){
			e.getStackTrace();
		}
	}

	public List<Category> getCategories() {
		return categories;
	}

}
