package jpa;

import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.text.ParseException;

public class UserDbDaoTest {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("module01-persistence-unit");
    private static EntityManager em = emf.createEntityManager();
    private EntityTransaction tx;

    @Before
    public void init() {
        tx = em.getTransaction();
    }

    @Test
    public void create() throws ParseException {
        //------------arrange------------


        //------------act------------


        //------------assert------------


    }
}
