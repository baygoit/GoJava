package datasource;

import java.util.*;

import entities.Category;
import entities.Project;

public class LocalDataSource implements DataSource {
	private List<HashMap<Category, List<Project>>> data = new ArrayList<HashMap<Category, List<Project>>>();

	public LocalDataSource() {
		for (int i = 0; i < 6; i++) {
			Category category = new Category(i, "Category " + i);
			data.add(new HashMap<Category, List<Project>>());
			data.get(0).put(category, new ArrayList<Project>());
			for (int j = 0; j < 6; j++) {
				Project project = new Project(i*j, "project "+i*j, 
						"short description of project" + i*j, i*j*10, 
						i*j, i*j/2, 
						"some histry", "video URL", null);
				data.get(0).get(category).add(project);
			}	
		}
	}

	@Override
	public ArrayList<Category> getCategoriesList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSomeQuote() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Project> getProjectsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCategoryName(int categoryIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project getProject(int category, int project) {
		// TODO Auto-generated method stub
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
