package dao.hibernate;

import dbutils.HibernateUtil;
import entity.Home;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;


public class HomeDao {

    private Session session;
    protected static Logger logger;

    public void create(Home home) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(home);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            session.close();
        }
    }

    public Home readById(int Id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Home home = session.get(Home.class, Id);
        session.getTransaction().commit();
        session.close();
        return home;
    }

    public void readByCityName(String cityName) {

    }
}
