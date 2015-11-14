package dao.hibernate;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDbDao {

    private SessionFactory sessionFactory;
    private Session session;

    public void create(User user) {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        sessionFactory.close();
    }
}
