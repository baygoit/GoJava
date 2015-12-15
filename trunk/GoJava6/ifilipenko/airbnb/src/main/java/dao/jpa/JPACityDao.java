package dao.jpa;


import dao.ICityDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JPACityDao implements ICityDao{

    @PersistenceContext
    EntityManager entityManager;



}
