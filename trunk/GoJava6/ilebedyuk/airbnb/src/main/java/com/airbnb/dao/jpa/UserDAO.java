package com.airbnb.dao.jpa;

import com.airbnb.dao.IUserDao;
import com.airbnb.model.User;
import com.airbnb.model.UserType;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Игорь on 13.11.2015.
 */
@Component
public class UserDAO implements IUserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public List<User> getUserList() {
        List<User> users = em.createQuery("Select a from User a", User.class).getResultList();
        return users;
    }

    @Override
    @Transactional
    public User getUser(int id) {
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    @Transactional
    public void updateName(int id, String newName) {
        User user = em.find(User.class, id);
        user.setName(newName);
    }

    @Override
    @Transactional
    public void updateUserType(int id) {
        User user = em.find(User.class, id);
        user.setUserType(String.valueOf(UserType.HOST));
    }

    @Override
    @Transactional
    public void delete(int id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }

    @Override
    @Transactional
    public void addToDb(User user) {
        em.persist(user);
    }

//    public static void main(String[] args) {
//        UserDAO userDAO = new UserDAO();
//        User user = new User("Yur", "Mity", "mity@gmail.co", "wer");
//        userDAO.addToDb(user);
//        userDAO.updateName(16, "Olya");
//        System.out.println(user);
//        List<User> users = userDAO.getUserList();
//
//        for (User user : users) {
//            System.out.println(user);
//        }
        //userDAO.addToDb(user);
   // }
}
