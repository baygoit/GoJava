package com.azuiev.Filter;

import com.azuiev.Books.ApartType;
import com.azuiev.Books.Book;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lera on 28.09.2015.
 */
public class FilterByApartType implements Filter {
    public List<Book> books = new LinkedList<Book>();
    private ApartType apartType;
    private FilterByCity filter;

    FilterByApartType(FilterByCity filter, ApartType apartType) {
        this.filter = filter;
        this.apartType = apartType;
    }

    @Override
    public List<Book> selectBooks() {
        books = filter.selectBooks();
            for (Book book : books) {
                if (!apartType.equals(book.getApartType())) {
                    books.remove(book);
                }
            }
        return books;
    }
}
