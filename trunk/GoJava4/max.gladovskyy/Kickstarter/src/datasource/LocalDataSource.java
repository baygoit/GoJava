package datasource;

import java.util.ArrayList;

import entities.Category;
import entities.Project;

public class LocalDataSource implements DataSource {

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
