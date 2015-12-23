package gojava.dao;

import gojava.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * Created by root on 04.11.15.
 */
@Component
public class UserDAO {

    /** JPA **/
    /*private EntityManagerFactory entityManagerFactory =
            Persistence.getPersistenceUtil("AirbnbPU");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction entityTransaction = null;*/

    /** Spring JPA **/
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<User> findAll() {
        List <User> users = entityManager.createQuery("Select a from User a", User.class)
                .getResultList();
        return users;
    }

    @Transactional
    public User findEntityById(Integer id) {
        User user = entityManager.find(User.class, id);
        return user;
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
