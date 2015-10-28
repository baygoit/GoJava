package goit.nz.kickstarter.dao.hibernate;

import goit.nz.kickstarter.dao.AbstractHibernateDAO;
import goit.nz.kickstarter.dao.CategoryDAO;
import goit.nz.kickstarter.domain.Category;

import java.util.List;

import org.hibernate.Query;

public class CategoryDAOImplHibernate extends AbstractHibernateDAO implements
		CategoryDAO {

	@Override
	@SuppressWarnings("unchecked")
	public List<Category> getCategories() {
		return (List<Category>) getSession().createQuery("from Category").list();
	}

	@Override
	public Category getCategory(long categoryId) {
		Query query = getSession().createQuery("from Category where id = :id");
		query.setLong("id", categoryId);
		return (Category) query.uniqueResult();
	}

}
