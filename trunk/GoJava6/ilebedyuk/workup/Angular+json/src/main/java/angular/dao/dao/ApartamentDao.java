package angular.dao.dao;

import angular.dao.model.Apartament;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Игорь on 16.12.2015.
 */
@Component
public class ApartamentDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<Apartament> getApartmentList() {
        List<Apartament> apartments = em.createQuery("select a from Apartament a", Apartament.class).getResultList();
        return apartments;
    }

    @Transactional
    public Apartament getApartment(int id) {
        Apartament apartment = em.find(Apartament.class, id);
        return apartment;
    }

    @Transactional
    public void delete(int id) {
        Apartament apartment = em.find(Apartament.class, id);
        em.remove(apartment);
    }

    @Transactional
    public void addToDb(Apartament apartment) {
        em.persist(apartment);
    }

}
