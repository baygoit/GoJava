package com.tyomsky.kickstarter.dao;

import com.tyomsky.kickstarter.model.Category;
import com.tyomsky.kickstarter.model.Project;
import java.util.List;

public interface DataProvider {

    List<Category> getCategoriesList();

    String getSomeQuote();

    Category getCategory(int categoryIndex);

	Project getProject(int category, int project);

}
