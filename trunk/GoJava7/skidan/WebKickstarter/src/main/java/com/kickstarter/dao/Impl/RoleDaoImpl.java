package com.kickstarter.dao.Impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kickstarter.dao.Interfaces.RoleDao;
import com.kickstarter.model.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(readOnly = true)
	public Role getRoleById(int roleId) {
		return entityManager.find(Role.class, roleId);
	}

}
