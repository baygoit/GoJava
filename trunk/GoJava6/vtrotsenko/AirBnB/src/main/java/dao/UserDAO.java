package dao;

import model.User;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * Created by root on 04.11.15.
 */
public class UserDAO implements AbstractDAO<Integer, User> {

    /** JPA **/
    /*private EntityManagerFactory entityManagerFactory =
            Persistence.getPersistenceUtil("AirbnbPU");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction entityTransaction = null;*/

    /** Spring JPA **/
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAll() {

        //TODO: using persistenceContext add logic
        /*List <User> users = null;
        try {
            entityTransaction.begin();
            users = entityManager.createQuery("FROM User").getResultList();
            entityTransaction.commit();
        } catch (RuntimeException e) {
            if (entityTransaction.isActive()) entityTransaction.rollback();
            e.printStackTrace();
        }
        return users;*/
        return null;
    }
    public User findEntityById(Integer id) {
        return null;
    }

    public boolean delete(Integer id) {
        return false;
    }

    public boolean delete(User entity) {
        return false;
    }

    @Transactional
    public User create(User entity) {
        entityManager.persist(entity);
        return entity;
    }

    public User update(User entity) {
        return null;
    }
}
