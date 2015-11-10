package com.gojava6.persistence.lesson3.demo04;


import com.gojava6.persistence.lesson3.CD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Main {

  public static void main(String[] args) {

    System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("module04-persistence-unit");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    ItemService service = new ItemService(em);

    // Creates and persists a CD
    tx.begin();
    CD cd = new CD("Sergent Pepper");
    cd = service.createCD(cd);
    tx.commit();

    System.out.println("CD Persisted : " + cd);

    // Finds the cd
    cd = service.findCD(cd.getId());

    System.out.println("CD Found     : " + cd);

    // Removes the cd
    tx.begin();
    service.removeCD(cd);
    tx.commit();

    System.out.println("CD Removed");

    // Finds the cd
    cd = service.findCD(cd.getId());

    System.out.println("CD Not Found : " + cd);

    em.close();
    emf.close();
  }
}


