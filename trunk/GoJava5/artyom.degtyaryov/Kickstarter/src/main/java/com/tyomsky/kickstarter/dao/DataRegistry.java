package com.tyomsky.kickstarter.dao;

import com.tyomsky.kickstarter.model.Category;
import com.tyomsky.kickstarter.model.Project;
import java.util.List;

public interface DataRegistry {

    List<Category> getCategoriesList();

    String getSomeQuote();

    Category getCategoryById(int categoryId);

	Project getProjectById(int categoryId, int projectId);

}
