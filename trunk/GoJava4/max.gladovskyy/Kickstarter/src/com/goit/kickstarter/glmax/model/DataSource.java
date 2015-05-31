package com.goit.kickstarter.glmax.model;

import java.util.ArrayList;
import java.util.List;

import com.goit.kickstarter.glmax.controller.Position;
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

	ArrayList<Integer> getChoisList(Position currentLevel, Integer integer);

	void persistData();

}
