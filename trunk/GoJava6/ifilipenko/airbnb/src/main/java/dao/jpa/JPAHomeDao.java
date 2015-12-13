package dao.jpa;

import dao.IHomeDao;
import entity.Home;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JPAHomeDao implements IHomeDao{

    @PersistenceContext
    EntityManager entityManager;

    public void create(Home home) {

    }

    public Home readById(int Id) {

        return null;

    }

    public void readByCityName(String cityName) {

    }
}
