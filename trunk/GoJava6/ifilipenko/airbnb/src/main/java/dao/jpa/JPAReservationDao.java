package dao.jpa;

import dao.IReservationDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JPAReservationDao implements IReservationDao{

    @PersistenceContext
    EntityManager entityManager;
}
