package com.gojava6.persistence.lesson2.demo4;

import com.gojava6.persistence.lesson2.CD;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CDTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static EntityManagerFactory emf;
  private static EntityManager em;
  private static EntityTransaction tx;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @Before
  public void initEntityManager() {
    emf = Persistence.createEntityManagerFactory("module03-persistence-unit-test");
    em = emf.createEntityManager();
    tx = em.getTransaction();
  }

  @After
  public void closeEntityManager() {
    if (em != null) em.close();
    if (emf != null) emf.close();
  }

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldCreateACD() {

    // Creates a CD
    CD cd = new CD("Selling England by the Pound", "5th studio album by the progressive rock band Genesis", 12.5F, 53.39F, "Progressive Rock");

    // Persists the CD
    tx.begin();
    em.persist(cd);
    tx.commit();
    Long id = cd.getId();

    // Finds the CD by primary key
    cd = em.find(CD.class, id);
    assertEquals(cd.getTitle(), "Selling England by the Pound");

    // Updates the CD
    tx.begin();
    cd.setTitle("Fox Trot");
    tx.commit();

    // Finds the CD by primary key
    cd = em.find(CD.class, id);
    assertEquals(cd.getTitle(), "Fox Trot");

    // Deletes the CD
    tx.begin();
    em.remove(cd);
    tx.commit();

    // Checks the CD has been deleted
    assertNull("CD should has been deleted", em.find(CD.class, id));
  }
}