package vadyazakusylo.kickstarter.model.dao;

import java.util.List;

import vadyazakusylo.kickstarter.model.Category;
import vadyazakusylo.kickstarter.model.exception.GettingDateException;

public interface CategoriesDao {

	List<Category> getCategoriesList() throws GettingDateException;

}
