package belskii.artem.kickstarter.dao.category;

import java.util.HashMap;

public interface CategoryDao {
	public void addCategory(String categoryInfo);
	public HashMap<Integer, String> getCategoryList();
	public String getCategoryNameById(int id);
}
