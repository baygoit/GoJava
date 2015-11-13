package com.gojava6.persistence.lesson2.demo03;


import com.gojava6.persistence.lesson2.Author;

import javax.persistence.EntityManager;

public class AuthorService {

  // ======================================
  // =             Attributes             =
  // ======================================

  private EntityManager em;

  // ======================================
  // =            Constructors            =
  // ======================================

  public AuthorService(EntityManager em) {
    this.em = em;
  }

  // ======================================
  // =           Public Methods           =
  // ======================================

  public Author createAuthor(Author book) {
    em.persist(book);
    return book;
  }

  public void removeAuthor(Author book) {
    em.remove(em.merge(book));
  }

  public Author findAuthor(Long id) {
    return em.find(Author.class, id);
  }
}