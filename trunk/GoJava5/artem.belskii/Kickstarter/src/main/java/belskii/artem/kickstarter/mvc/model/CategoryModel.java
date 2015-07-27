package belskii.artem.kickstarter.mvc.model;

import java.util.List;
import belskii.artem.kickstarter.dao.Category;
import belskii.artem.kickstarter.dao.CategoryDao;
import belskii.artem.kickstarter.dao.CategoryDaoImplHardCoding;

public class CategoryModel {
	CategoryDao categoryDao = new CategoryDaoImplHardCoding();

	public void addCategory(Category categoryInfo) {
		categoryDao.addCategory(categoryInfo);
	}

	public List<Category> getCategoryList() {
		return categoryDao.getCategoryList();
	}
}
