package dao.hibernate;

import dbutils.HibernateUtil;
import model.User;
import org.hibernate.Session;

public class UserDao {

    private Session session;

    public void create(User user) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public User readById(int userId) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = session.get(User.class, userId);
        session.getTransaction().commit();
        session.close();

        return user;
    }
}
