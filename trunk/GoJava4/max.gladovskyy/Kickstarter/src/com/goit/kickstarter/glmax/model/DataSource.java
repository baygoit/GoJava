package com.goit.kickstarter.glmax.model;

import java.util.ArrayList;

import com.goit.kickstarter.glmax.enteties.Category;
import com.goit.kickstarter.glmax.enteties.Project;

public interface DataSource {

	ArrayList<Category> getCategoriesList();

	String getSomeQuote();

	ArrayList<Project> getProjectsList(int categoryIndex);

	String getCategoryName(int categoryIndex);

	Project getProject(int category, int project);

	boolean checkIfProjectExist(int i, int userChoise);

	boolean checkIfCategoryExist(int userChoise);

}
