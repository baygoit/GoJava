package angular.dao.dao;

import angular.dao.model.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Игорь on 16.12.2015.
 */
@Component
public class UserDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<User> getUserList() {
        List<User> users = em.createQuery("Select a from User a", User.class).getResultList();
        return users;
    }

    @Transactional
    public User getUser(int id) {
        User user = em.find(User.class, id);
        return user;
    }

    @Transactional
    public void updateName(int id, String newName) {
        User user = em.find(User.class, id);
        user.setName(newName);
    }

//    @Transactional
//    public void updateUserType(int id) {
//        User user = em.find(User.class, id);
//        user.setUserType(UserType.HOST.getUserType());
//    }

    @Transactional
    public void delete(int id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }

    @Transactional
    public void addToDb(User user) {
        em.persist(user);
    }

}
