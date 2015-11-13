package com.gojava6.persistence.lesson2.demo03;


import static com.gojava6.persistence.lesson2.Util.date;
import static com.gojava6.persistence.lesson2.Language.ENGLISH;

import com.gojava6.persistence.lesson2.Author;

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

    AuthorService service = new AuthorService(em);
    Author author = new Author("Douglas", "Adams", "Adams is best known as the author of H2G2", date("11/03/1952"), 49, ENGLISH);

    // Creates and persists an author
    tx.begin();
    author = service.createAuthor(author);
    tx.commit();
    Long id = author.getId();

    System.out.println("Author Persisted : " + author);

    // Finds the author
    author = service.findAuthor(id);

    System.out.println("Author Found     : " + author);

    // Removes the author
    tx.begin();
    //service.removeAuthor(author);
    tx.commit();

    System.out.println("Author Removed");

    // Finds the author
    author = service.findAuthor(id);

    System.out.println("Author Not Found : " + author);

    em.close();
    emf.close();
  }
}


