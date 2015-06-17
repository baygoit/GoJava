package vadyazakusylo.kickstarter.model.dao;

import java.util.List;

import vadyazakusylo.kickstarter.model.Category;
import vadyazakusylo.kickstarter.model.exception.GettingDateException;

public abstract class CategoriesDao {

	public abstract List<Category> getCategoriesList() throws GettingDateException;

}
