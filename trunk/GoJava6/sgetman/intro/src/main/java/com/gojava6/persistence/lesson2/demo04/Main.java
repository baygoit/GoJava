package com.gojava6.persistence.lesson2.demo04;


import com.gojava6.persistence.lesson2.CD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class Main {

  public static void main(String[] args) throws SQLException, ClassNotFoundException {

    System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("module01-persistence-unit");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    CDService service = new CDService(em);
    CD cd = new CD("Selling England by the Pound", "5th studio album by the progressive rock band Genesis", 12.5F, 53.39F, "Progressive Rock");

    // Creates and persists an cd
    tx.begin();
    cd = service.createCD(cd);
    tx.commit();
    Long id = cd.getId();

    System.out.println("CD Persisted : " + cd);

    // Finds the cd
    cd = service.findCD(id);

    System.out.println("CD Found     : " + cd);

    // Removes the cd
    tx.begin();
    service.removeCD(cd);
    tx.commit();

    System.out.println("CD Removed");

    // Finds the cd
    cd = service.findCD(id);

    System.out.println("CD Not Found : " + cd);

    em.close();
    emf.close();
  }
}


