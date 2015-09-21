package belskii.artem.kickstarter.dao.category;

import java.util.Map;

public interface CategoryDao {
	public void addCategory(String categoryInfo);
	public Map<Integer, String> getCategoryList();
	public String getCategoryNameById(int id);
	public void initDemoDB();
	public int getCaterogyIdByName(String categoryName);
}
