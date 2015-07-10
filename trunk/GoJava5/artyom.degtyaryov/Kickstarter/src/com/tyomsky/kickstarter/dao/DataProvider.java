package com.tyomsky.kickstarter.dao;

import com.tyomsky.kickstarter.domain.Category;
import com.tyomsky.kickstarter.domain.Project;
import java.util.List;

public interface DataProvider {

    List<Category> getCategoriesList();

    String getSomeQuote();

    Category getCategory(int categoryIndex);

	Project getProject(int category, int project);

}
