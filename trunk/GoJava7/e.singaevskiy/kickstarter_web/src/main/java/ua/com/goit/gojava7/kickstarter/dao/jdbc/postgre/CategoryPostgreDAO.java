package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.util.HashMap;
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
	public List<HashMap<String,Object>> getTopDonated(int limit) {
		String query = "select category.id, category.name, " +
			"sum(coalesce(payment.sum,0)) as sum " +
			"from category " +
			"left join project on category.id = project.category_id " +
			"left join payment on project.id = payment.project_id " +
			"group by category.id, category.name " +
			"order by sum desc, category.name " +
			"limit ?";
		return HibernateUtil.getForSQL(query, limit);
	}
	
}
