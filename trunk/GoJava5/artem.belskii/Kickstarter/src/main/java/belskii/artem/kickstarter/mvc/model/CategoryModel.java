package belskii.artem.kickstarter.mvc.model;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import belskii.artem.kickstarter.dao.category.CategoryDao;

public class CategoryModel {
	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
	CategoryDao categoryDao = (CategoryDao) context.getBean("categoryDaoImplPsql"); 
			//new CategoryDaoImplPsql("conf/database.conf");
			//("src/main/conf/database.conf");

	public void addCategory(String categoryName) {
		categoryDao.addCategory(categoryName);
	}

	public Map<Integer, String> getCategoryList() {
		return categoryDao.getCategoryList();
	}
}
