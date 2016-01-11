package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.HibernateUtil;
import ua.com.goit.gojava7.kickstarter.domain.Category;

@Repository
public class CategoryPostgreDAO implements CategoryDAO {
	@Autowired
	private HibernateUtil hiberUtil;

	@Override
	public void clear() {
		hiberUtil.executeUpdate("delete Category");
	}

	@Override
	public Category get(int index) {
		return hiberUtil.get("from Category where id = ?", index);
	}

	@Override
	public void add(Category element) {
		hiberUtil.save(element);
	}

	@Override
	public void addAll(List<Category> elements) {
		hiberUtil.save(elements);
	}

	@Override
	public List<Category> getAll() {
		return hiberUtil.getList("from Category");
	}

	@Override
	public List<HashMap<String, Object>> getTopDonated(int limit) {
		String query = "select category.id, category.name, " 
				+ "sum(coalesce(payment.sum,0)) as sum " 
				+ "from category "
				+ "left join project on category.id = project.category_id " 
				+ "left join payment on project.id = payment.project_id "
				+ "group by category.id, category.name " + "order by sum desc, category.name " 
				+ "limit ?";
		return hiberUtil.getForSQL(query, limit);
	}

}
