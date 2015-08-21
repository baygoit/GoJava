package belskii.artem.kickstarter.mvc.model;

import java.util.Map;

import belskii.artem.kickstarter.dao.category.CategoryDao;
import belskii.artem.kickstarter.dao.category.CategoryDaoImplPsql;

public class CategoryModel {
	CategoryDao categoryDao = new CategoryDaoImplPsql("src/main/conf/database.conf");

	public void addCategory(String categoryName) {
		categoryDao.addCategory(categoryName);
	}

	public Map<Integer, String> getCategoryList() {
		return categoryDao.getCategoryList();
	}
}
