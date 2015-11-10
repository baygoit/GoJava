package com.gojava6.persistence.lesson2.demo01;


import com.gojava6.persistence.lesson2.Book;

import javax.persistence.EntityManager;


public class BookService {

  // ======================================
  // =             Attributes             =
  // ======================================

  private EntityManager em;

  // ======================================
  // =            Constructors            =
  // ======================================

  public BookService(EntityManager em) {
    this.em = em;
  }

  // ======================================
  // =           Public Methods           =
  // ======================================

  public Book createBook(Book book) {
    em.persist(book);
    return book;
  }

  public Book createBook(Long id, String title, String description, Float unitCost, String isbn, Integer nbOfPage) {
    Book book = new Book();
    book.setId(id);
    book.setTitle(title);
    book.setDescription(description);
    book.setUnitCost(unitCost);
    book.setIsbn(isbn);
    book.setNbOfPage(nbOfPage);
    em.persist(book);
    return book;
  }

  public void removeBook(Book book) {
    em.remove(em.merge(book));
  }

  public void removeBook(Long id) {
    Book book = em.find(Book.class, id);
    if (book != null)
      em.remove(book);
  }

  public Book findBook(Long id) {
    return em.find(Book.class, id);
  }

  public Book raiseUnitCost(Long id, Float raise) {
    Book book = em.find(Book.class, id);
    if (book != null)
      book.setUnitCost(book.getUnitCost() + raise);
    return book;
  }
}