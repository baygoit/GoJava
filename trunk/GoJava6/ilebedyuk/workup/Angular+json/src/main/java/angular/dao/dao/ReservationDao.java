package angular.dao.dao;

import angular.dao.model.Reservation;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Игорь on 16.12.2015.
 */
@Component
public class ReservationDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<Reservation> getReservationDateList() {
        List<Reservation> reservationDates = em.createQuery("select r from Reservation r", Reservation.class).getResultList();
        return reservationDates;
    }

    @Transactional
    public List<Reservation> getReservationDateListByIdApartament(int idApartament) {
//        EntityManager em = emf.createEntityManager();
//        List<ReservationDate> reservationDates = null;
//        try {
//            em.getTransaction().begin();
//            Query query = em.createNamedQuery("find reservation dates by apartament id");
//            query.setParameter("id", idApartament);
//            reservationDates = query.getResultList();
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//        } finally {
//            em.close();
//        }
        return null;
    }

    @Transactional
    public Reservation getReservationDate(int id) {
        Reservation reservationDate = em.find(Reservation.class, id);
        return reservationDate;
    }

    @Transactional
    public void delete(int id) {
        Reservation reservationDate = em.find(Reservation.class, id);
        em.remove(reservationDate);
    }

    @Transactional
    public void addToDb(Reservation reservationDate) {
        em.persist(reservationDate);
    }
}
