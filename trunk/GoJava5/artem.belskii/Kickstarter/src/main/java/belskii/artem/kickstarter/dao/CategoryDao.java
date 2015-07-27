package belskii.artem.kickstarter.dao;

import java.util.List;

public interface CategoryDao {
	public void addCategory(Category categoryInfo);

	public List<Category> getCategoryList();

	public String getCategoryById(int id);
}
