package jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Игорь on 30.11.2015.
 */
public class Dao {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create(User user) {
        em.persist(user);
    }

    @Transactional
    public List<User> getAllUsers() {
        List<User> users = em.createQuery("select u from User u").getResultList();
        return users;
    }
}
