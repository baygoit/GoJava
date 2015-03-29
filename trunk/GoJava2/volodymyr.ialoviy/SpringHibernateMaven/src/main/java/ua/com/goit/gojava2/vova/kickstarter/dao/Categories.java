package ua.com.goit.gojava2.vova.kickstarter.dao;

import java.util.List;

import org.hibernate.Query;
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
	public void deleteCategoryById(Integer idCategory) {
		Query query = getSession().createSQLQuery("delete from Categories where id_category = :idCategory");//TODO DELETE hQL заменить шкюел на сессии.
		query.setInteger("idCategory", idCategory);
		query.executeUpdate();
	}

	@Override
	public Category findCategoryById(int id) {
		for (Category category : findAllCategories()){
			if(category.getIdCategory() == id){
				return category;
			}
		}
		throw new IllegalArgumentException("Category with this id not found");
	}
	
}
