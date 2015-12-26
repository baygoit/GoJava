package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.HibernateUtil;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryPostgreDAO implements CategoryDAO {

	@Override
	public void clear() {
		HibernateUtil.executeUpdate("delete Category");
	}

	@Override
	public Category get(int index) {
		return HibernateUtil.get("from Category where id = ?", index);
	}

	@Override
	public void add(Category element) {
		HibernateUtil.save(element);
	}

	@Override
	public void addAll(List<Category> elements) {
		HibernateUtil.save(elements);
	}

	@Override
	public List<Category> getAll() {
		return HibernateUtil.getList("from Category");
	}
	
	@Override
	public List<Category> getTopDonated(int limit) {
		return HibernateUtil.getList("select category \n"+
			"from Category category \n"+
			"join Project project on category.id = project.category_id \n"+
			"join Payment payment on project.id = payment.project_id \n"+
			"group by category.id, category.name \n"+
			"order by sum(payment.sum) desc \n"
			//+"limit 10"
			);
	}
	
	public void name() {
		HibernateUtil.getList("from Category join Project ");
	}

}
