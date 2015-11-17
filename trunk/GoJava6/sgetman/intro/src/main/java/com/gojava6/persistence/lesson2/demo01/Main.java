package com.gojava6.persistence.lesson2.demo01;


import com.gojava6.persistence.lesson2.Book;

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

    BookService service = new BookService(em);

    // Creates and persists a Book
    tx.begin();
    Book book = service.createBook(4044L, "H2G2", "Best IT Scifi Book", 12.5f, "1234-5678-5678", 247);
    tx.commit();

    System.out.println("Book Persisted : " + book);

    // Finds the book
    book = service.findBook(4044L);

    System.out.println("Book Found     : " + book);

    // Raises the price of the book
    tx.begin();
    book = service.raiseUnitCost(4044L, 12.5F);
    tx.commit();

    System.out.println("Book Updated   : " + book);

    // Removes the book
    tx.begin();
    service.removeBook(4044L);
    tx.commit();

    System.out.println("Book Removed");

    // Finds the book
    book = service.findBook(4044L);

    System.out.println("Book Not Found : " + book);

    em.close();
    emf.close();
  }
}


