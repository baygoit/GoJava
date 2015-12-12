package dao.jpa;


import dao.IUserDao;
import dbutils.HibernateUtil;
import entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JPAUserDao implements IUserDao{

    protected EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void create(User user) {
        getEntityManager().persist(user);
    }

    @Transactional
    public User readById(int userId) {
        return getEntityManager().find(User.class, userId);
    }


}
