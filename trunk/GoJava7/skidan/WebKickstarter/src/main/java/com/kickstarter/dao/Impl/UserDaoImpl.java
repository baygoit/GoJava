package com.kickstarter.dao.Impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.kickstarter.dao.Interfaces.UserDao;
import com.kickstarter.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void addUser(User user) {
		System.out.println("Before persisting");
		entityManager.persist(user);
	}

	@Transactional
	public void editUser(User user) {
		entityManager.merge(user);

	}

	@Transactional
	public void deleteUser(int userId) {
		entityManager.remove(getUser(userId));
	}

	@Transactional
	public User getUser(int userId) {
		return entityManager.find(User.class, userId);
	}

	@Transactional
	public User getUserByName(String userName) {
			return 	(User) entityManager.createQuery("from User where name= :userName")
					.setParameter("userName", userName)
					.getSingleResult();
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<User> getUserList() {
		return entityManager.createQuery("from User").getResultList();
	}

}
