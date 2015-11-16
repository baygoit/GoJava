package dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DbAccess {

    private static EntityManagerFactory emf;
    private static EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    public DbAccess(EntityManagerFactory emf, EntityManager em, EntityTransaction tx, String unit){
        this.emf = Persistence.createEntityManagerFactory("module01-persistence-unit");

    }

}
