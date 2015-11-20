package com.gojava6.persistence.lesson3.demo03;


import com.gojava6.persistence.lesson3.Book;
import com.gojava6.persistence.lesson3.CD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

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
    CD cd = new CD("Sergent Pepper", "Pop/Rock");
    cd = service.createCD(cd);
    tx.commit();

    System.out.println("CD Persisted   : " + cd);

    // Creates and persists a CD
    tx.begin();
    Book book = new Book("H2G2", "1234-4567-5678");
    book = service.createBook(book);
    tx.commit();

    System.out.println("Book Persisted : " + book);

    em.close();
    emf.close();
  }
}


