package belskii.artem.kickstarter.mvc.model;

import java.util.HashMap;

import belskii.artem.kickstarter.dao.category.CategoryDao;
import belskii.artem.kickstarter.dao.category.CategoryDaoImplHardCoding;

public class CategoryModel {
	CategoryDao categoryDao = new CategoryDaoImplHardCoding();

	public void addCategory(String categoryName) {
		categoryDao.addCategory(categoryName);
	}

	public HashMap<Integer, String> getCategoryList() {
		return categoryDao.getCategoryList();
	}
}
