package com.gojava6.persistence.lesson3.demo03;


import com.gojava6.persistence.lesson3.Book;
import com.gojava6.persistence.lesson3.CD;

import javax.persistence.EntityManager;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class ItemService {

  // ======================================
  // =             Attributes             =
  // ======================================

  private EntityManager em;

  // ======================================
  // =            Constructors            =
  // ======================================

  public ItemService(EntityManager em) {
    this.em = em;
  }

  // ======================================
  // =           Public Methods           =
  // ======================================

  public CD createCD(CD cd) {
    em.persist(cd);
    return cd;
  }

  public void removeCD(CD cd) {
    em.remove(em.merge(cd));
  }

  public CD findCD(Long id) {
    return em.find(CD.class, id);
  }

  public Book createBook(Book book) {
    em.persist(book);
    return book;
  }

  public void removeBook(Book book) {
    em.remove(em.merge(book));
  }

  public Book findBook(Long id) {
    return em.find(Book.class, id);
  }
}