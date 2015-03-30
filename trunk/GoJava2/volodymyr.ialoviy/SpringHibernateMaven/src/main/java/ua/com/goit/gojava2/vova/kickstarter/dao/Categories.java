package ua.com.goit.gojava2.vova.kickstarter.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava2.vova.kickstarter.model.Category;

@Repository("categoryDao")
public class Categories extends AbstractDao implements CategoryDao{

	@Override
	public void saveCategory(Category category) {
		persist(category);
	}

	@Override
	public List<Category> findAllCategories() {
		List<Category> result = (List<Category>) getSession().createQuery("from Category").list();
		return result;
	}
	
	@Override
	public void deleteCategoryById(int id) {
		Query query = getSession().createSQLQuery("delete from Categories where id = :id");//TODO DELETE hQL заменить шкюел на сессии.
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@Override
	public Category findCategoryById(int id) {
//		for (Category category : findAllCategories()){
//			if(category.getId() == id){
//				return category;
//			}
//		}
//		throw new IllegalArgumentException("Category with this id not found");
		
		Session session = getSession();
        Category category = (Category) session.get(Category.class, id);
        session.close();
        return category;
	}
	
}
