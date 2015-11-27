package dao.hibernate;

import dbutils.HibernateUtil;
import model.Home;
import org.hibernate.Session;

public class HomeDao {

    private Session session;

    public void create(Home home) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(home);
        session.getTransaction().commit();
        session.close();

    }
}
