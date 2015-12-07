package com.airbnb.dao.jpa;

import com.airbnb.dao.IReservationDao;
import com.airbnb.model.ReservationDate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Игорь on 14.11.2015.
 */
@Component
public class ReservationDatesDAO implements IReservationDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public List<ReservationDate> getReservationDateList() {
        List<ReservationDate> reservationDates = em.createQuery("select r from ReservationDate r", ReservationDate.class).getResultList();
        return reservationDates;
    }

    @Override
    @Transactional
    public List<ReservationDate> getReservationDateListByIdApartament(int idApartament) {
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

    @Override
    @Transactional
    public ReservationDate getReservationDate(int id) {
        ReservationDate reservationDate = em.find(ReservationDate.class, id);
        return reservationDate;
    }

    @Override
    @Transactional
    public void delete(int id) {
        ReservationDate reservationDate = em.find(ReservationDate.class, id);
        em.remove(reservationDate);
    }

    @Override
    @Transactional
    public void addToDb(ReservationDate reservationDate) {
        em.persist(reservationDate);
    }
}