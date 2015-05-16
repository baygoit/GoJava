package datasource;

import java.util.*;

import entities.Category;
import entities.Project;
import entities.Quote;

public class LocalDataSource implements DataSource {
	private List<HashMap<Category, ArrayList<Project>>> data = new ArrayList<HashMap<Category, ArrayList<Project>>>();

	public LocalDataSource() {
		for (int i = 0; i < 6; i++) {
			Category category = new Category(i, "Category " + i);
			data.add(new HashMap<Category, ArrayList<Project>>());
			data.get(0).put(category, new ArrayList<Project>());
			for (int j = 0; j < 6; j++) {
				Project project = new Project(i * j, "project " + i * j,
						"short description of project" + i * j, i * j * 10, i
								* j, i * j / 2, "some histry", "video URL",
						null);
				data.get(0).get(category).add(project);
			}
		}
	}

	@Override
	public ArrayList<Category> getCategoriesList() {
		ArrayList<Category> result = new ArrayList<Category>();
		for (HashMap<Category, List<Project>> category : data) {
			for (Category c : category.keySet()) {
				result.add(c);
			}
		}
		return result;
	}

	@Override
	public String getSomeQuote() {
		return "some qoute";
	}

	@Override
	public ArrayList<Project> getProjectsList(int categoryIndex) {
		for (Category c : data.get(categoryIndex-1).keySet()) {
			ArrayList<Project> result = data.get(categoryIndex - 1).get(c);
			return result;
		}
		return null;
	}

	@Override
	public String getCategoryName(int categoryIndex) {
		for (Category c : data.get(categoryIndex-1).keySet()) {
			return c.getName();
		}
		return null;
	}

	@Override
	public Project getProject(int category, int project) {
		for (Category c : data.get(categoryIndex-1).keySet()) {
			return c;
		}
		return null;
	}

	@Override
	public boolean checkIfProjectExist(int i, int userChoise) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkIfCategoryExist(int userChoise) {
		// TODO Auto-generated method stub
		return false;
	}

}
