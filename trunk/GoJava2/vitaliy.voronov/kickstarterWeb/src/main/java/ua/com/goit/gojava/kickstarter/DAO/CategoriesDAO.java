package ua.com.goit.gojava.kickstarter.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava.kickstarter.Model.Categories;
import ua.com.goit.gojava.kickstarter.Model.Category;

@Component
public class CategoriesDAO extends AbstractDAO implements Categories {

	@Override
	public void add(Category category) {
		Session session = getSession();
		session.save(category);
		session.close();
	}

	@Override
	public List<Category> getAllCategories() {
		List<Category> list = (List<Category>) getSession().createCriteria(Category.class).list();
		return list;
	}

	@Override
	public Category getSelectCategory(int id) {
		return (Category) getSession().get(Category.class, id);
	}
}
