package ua.com.goit.gojava7.kickstarter.datasource.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.datasource.contract.UserDAO;
import ua.com.goit.gojava7.kickstarter.domain.User;

@Repository
public class UserPostgreDAO implements UserDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void clear() {
		entityManager.createNamedQuery("User.removeAll").executeUpdate();
	}

	@Override
	public User get(Long index) {
		return entityManager.find(User.class, index);
	}

	@Override
	@Transactional
	public void add(User element) {
		entityManager.persist(element);
	}

	@Override
	@Transactional
	public void addAll(List<User> elements) {
		elements.forEach(entityManager::persist);
	}

	@Override
	public List<User> getAll() {
		return entityManager.createNamedQuery("User.getAll", User.class).getResultList();
	}

	@Override
	public User getByEmail(String email) {
		TypedQuery<User> query = entityManager.createNamedQuery("User.getByEmail", User.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}


}
