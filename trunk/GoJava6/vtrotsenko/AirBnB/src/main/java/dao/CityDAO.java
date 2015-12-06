package dao;

import model.City;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by root on 17.11.15.
 */
public class CityDAO implements AbstractDAO<Integer, City> {

    private EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("AirbnbPU");

    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction = null;

    public List<City> findAll() throws SQLException {
        entityTransaction = entityManager.getTransaction();
        List <City> cities = null;
        try {
            entityTransaction.begin();
            cities = entityManager.createQuery("FROM City").getResultList();
            entityTransaction.commit();
        } catch (HibernateException e) {
            if (entityTransaction.isActive()) entityTransaction.rollback();
            e.printStackTrace();
        }
        return cities;
    }

    public City findEntityById(Integer id) {
        return null;
    }

    public boolean delete(Integer id) {
        return false;
    }

    public boolean delete(City entity) {
        return false;
    }

    public City create(City entity) {
        entityTransaction = entityManager.getTransaction();
        boolean flag = false;
        try {
            entityTransaction.begin();
            entityManager.persist(entity);
            entityTransaction.commit();
            flag = true;
        } catch (RuntimeException e) {
            if (entityTransaction.isActive())
                entityTransaction.rollback();
            e.printStackTrace();
        }

        return entity;
    }

    public City update(City entity) {
        return null;
    }

    public boolean isUnique(City entity) throws SQLException {
        List<City> cities = findAll();
        if (!cities.contains(entity)) {
            return true;
        }
        return false;
    }
}
