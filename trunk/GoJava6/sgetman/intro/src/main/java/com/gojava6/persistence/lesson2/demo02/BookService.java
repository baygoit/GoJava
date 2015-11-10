package com.gojava6.persistence.lesson2.demo02;


import com.gojava6.persistence.lesson2.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class BookService {

  /*
  book dao
   */
  private BookDao bookDao = new BookDao();
  // ======================================
  // =             Attributes             =
  // ======================================



  // ======================================
  // =           Public Methods           =
  // ======================================

  public Book createBook(Long id, String title, String description, Float unitCost, String isbn, Integer nbOfPage) {
    Book book = new Book();
    book.setId(id);
    book.setTitle(title);
    book.setDescription(description);
    book.setUnitCost(unitCost);
    book.setIsbn(isbn);
    book.setNbOfPage(nbOfPage);

    return bookDao.createBook(book);
  }

  public void removeBook(Long id) {
    bookDao.removeBook(id);
  }

  public Book findBook(Long id) {
    return bookDao.findBook(id);
  }

  public Book raiseUnitCost(Long id, Float raise) {
    return bookDao.raiseUnitCost(id, raise);
  }
}