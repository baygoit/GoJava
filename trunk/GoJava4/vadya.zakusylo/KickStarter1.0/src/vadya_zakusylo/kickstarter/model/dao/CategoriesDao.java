package vadya_zakusylo.kickstarter.model.dao;

import java.util.List;

import vadya_zakusylo.kickstarter.model.Category;
import vadya_zakusylo.kickstarter.model.exception.GettingDateException;

public abstract class CategoriesDao {

	public abstract List<Category> getCategoriesList() throws GettingDateException;

}
