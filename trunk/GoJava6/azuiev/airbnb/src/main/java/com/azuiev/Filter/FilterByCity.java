package com.azuiev.Filter;

import com.azuiev.Books.Book;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lera on 28.09.2015.
 */
public class FilterByCity implements Filter {
    private List<Book> books = new LinkedList<Book>();
    private String pattern;
    FilterByCity(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public List<Book> selectBooks() {
        LinkedList<Book> all = new LinkedList<Book>(Book.getBooks());
        for (Book book : all) {
            if (pattern.equals(book.getCity())) {
                books.add(book);
            }
        }
        return books;
    }
}
