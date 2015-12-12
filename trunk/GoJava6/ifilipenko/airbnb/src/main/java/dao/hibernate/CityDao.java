package dao.hibernate;

import dao.ICityDao;
import dbutils.HibernateUtil;
import entity.City;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CityDao implements ICityDao {
    private Session session;
    protected static Logger logger;
    ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

    public void create(City city) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(city);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            session.close();
        }

    }

    public City read(int id) {
        City city = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            city = session.get(City.class, id);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            session.close();
        }
        return city;
    }


}
