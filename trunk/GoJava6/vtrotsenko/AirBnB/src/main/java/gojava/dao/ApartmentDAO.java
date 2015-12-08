package gojava.dao;

import gojava.model.Apartment;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * Created by root on 04.11.15.
 */
public class ApartmentDAO implements AbstractDAO<Integer, Apartment> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Apartment> findAll() {
        return null;
    }

    public Apartment findEntityById(Integer id) {
        return null;
    }

    public boolean delete(Integer id) {
        return false;
    }

    public boolean delete(Apartment entity) {
        return false;
    }

    @Transactional
    public Apartment create(Apartment entity) {
        entityManager.persist(entity);
        return entity;
    }

    public Apartment update(Apartment entity) {
        return null;
    }
}
