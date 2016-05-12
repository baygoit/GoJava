package kickstarter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import kickstarter.domain.Category;

import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAO {

	@PersistenceContext
	protected EntityManager emf;

	@SuppressWarnings("unchecked")
	public List<Category> findAll() {

		return emf.createQuery("from categories c").getResultList();

	}

}
