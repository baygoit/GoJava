package dao.db;

import dbutils.HibernateUtil;
import model.Reservation;
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
