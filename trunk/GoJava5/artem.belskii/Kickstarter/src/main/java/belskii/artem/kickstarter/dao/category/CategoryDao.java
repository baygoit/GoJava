package belskii.artem.kickstarter.dao.category;

import java.util.ArrayList;

public interface CategoryDao {
	public void addCategory(Category categoryInfo);
	public ArrayList<Category> getCategoryList();
	public String getCategoryNameById(int id);
}
