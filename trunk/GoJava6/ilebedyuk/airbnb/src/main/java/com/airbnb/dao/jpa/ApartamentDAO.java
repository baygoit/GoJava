package com.airbnb.dao.jpa;

import com.airbnb.dao.IApartmentDao;
import com.airbnb.model.Apartment;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Игорь on 14.11.2015.
 */
@Component
public class ApartamentDAO implements IApartmentDao  {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public List<Apartment> getApartmentList() {
        List<Apartment> apartments = em.createQuery("select a from Apartment a", Apartment.class).getResultList();
        return apartments;
    }

    @Override
    @Transactional
    public Apartment getApartment(int id) {
        Apartment apartment = em.find(Apartment.class, id);
        return apartment;
    }

    @Override
    @Transactional
    public void delete(int id) {
        Apartment apartment = em.find(Apartment.class, id);
    }

    @Override
    @Transactional
    public void addToDb(Apartment apartment) {
        em.persist(apartment);
    }

//    public static void main(String[] args) {
//        ApartamentDAO apartamentDAO = new ApartamentDAO();
//        List<Apartment> apartments = apartamentDAO.getApartmentList();
//        for (Apartment apartment : apartments) {
//            System.out.println(apartment);
//        }
//
//    }
}
