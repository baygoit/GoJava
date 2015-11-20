package com.gojava6.persistence.lesson2.demo02;


import com.gojava6.persistence.lesson2.Book;

import java.sql.SQLException;


public class Main {

  public static void main(String[] args) throws SQLException, ClassNotFoundException {

    System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");

    BookService service = new BookService();

    // Creates and persists a Book
    Book book = service.createBook(4044L, "H2G2", "Scifi Book", 12.5f, "1234-5678-5678", 247);

    System.out.println("Book Persisted : " + book);

    // Finds the book
    book = service.findBook(4044L);

    System.out.println("Book Found     : " + book);

    // Raises the price of the book
    book = service.raiseUnitCost(4044L, 12.5F);

    System.out.println("Book Updated   : " + book);

    // Removes the book
    service.removeBook(4044L);

    System.out.println("Book Removed");

    // Finds the book
    book = service.findBook(4044L);

    System.out.println("Book Not Found : " + book);
  }
}


