package com.goit.kickstarter.glmax.model;

import java.util.*;

import com.goit.kickstarter.glmax.enteties.Category;
import com.goit.kickstarter.glmax.enteties.Project;

public class LocalDataSource implements DataSource {
	private List<HashMap<Category, ArrayList<Project>>> data = new ArrayList<HashMap<Category, ArrayList<Project>>>();

	public LocalDataSource() {
		for (int i = 0; i < 6; i++) {
			Category category = new Category(i, "Category " + i);
			data.add(new HashMap<Category, ArrayList<Project>>());
			data.get(i).put(category, new ArrayList<Project>());
			for (int j = 0; j < 6; j++) {
				Project project = new Project(i * j, "project " + i * j,
						"short description of project" + i * j, i * j * 10, i
								* j, i * j / 2, "some histry", "video URL",
						null);
				data.get(i).get(category).add(project);
			}
		}
	}

	@Override
	public ArrayList<Category> getCategoriesList() {
		ArrayList<Category> result = new ArrayList<Category>();
		for (HashMap<Category, ArrayList<Project>> category : data) {
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
		for (ArrayList<Project> p : data.get(categoryIndex - 1).values()) {
			ArrayList<Project> result = p;
			return result;
		}
		return null;
	}

	@Override
	public String getCategoryName(int categoryIndex) {
		try {
			for (Category c : data.get(categoryIndex-1).keySet()) {
				return c.getName();
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println("no such variant.");
			System.exit(0);
		}
		return null;
	}

	@Override
	public Project getProject(int category, int project) {
		try {
			for (Category c : data.get(category-1).keySet()) {
				Project result = data.get(category - 1).get(c).get(project-1);
				return result;
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println("no such variant.");
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
