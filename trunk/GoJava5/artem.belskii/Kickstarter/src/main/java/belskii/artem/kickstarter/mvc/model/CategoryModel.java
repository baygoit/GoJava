package belskii.artem.kickstarter.mvc.model;

import java.util.ArrayList;

import belskii.artem.kickstarter.dao.category.Category;
import belskii.artem.kickstarter.dao.category.CategoryDao;
import belskii.artem.kickstarter.dao.category.CategoryDaoImplHardCoding;

public class CategoryModel {
	CategoryDao categoryDao = new CategoryDaoImplHardCoding();

	public void addCategory(Category categoryInfo) {
		categoryDao.addCategory(categoryInfo);
	}

	public ArrayList<Category> getCategoryList() {
		return categoryDao.getCategoryList();
	}
}
