package com.tyomsky.kickstarter.dao;

import com.tyomsky.kickstarter.model.Category;
import com.tyomsky.kickstarter.model.Entity;
import com.tyomsky.kickstarter.model.Project;
import com.tyomsky.kickstarter.view.ViewTypes;

import java.util.ArrayList;

public interface DataProvider {

	ArrayList<Category> getCategoriesList();

	Entity getSomeQuote();

	ArrayList<Project> getProjectsList(int categoryIndex);

	String getCategoryName(int categoryIndex);

	Project getProject(int category, int project);

	ArrayList<Entity> getEntitiesList(ViewTypes viewType, int id);

}
