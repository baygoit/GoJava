package dao.hibernate;

import dbutils.HibernateUtil;
import entity.Reservation;
import org.hibernate.Session;

public class ReservationDao {
    private Session session;

    public void create(Reservation reservation) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(reservation);
        session.getTransaction().commit();
        session.close();
    }
}
