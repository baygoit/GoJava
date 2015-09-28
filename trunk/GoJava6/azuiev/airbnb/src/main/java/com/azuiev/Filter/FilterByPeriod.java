package com.azuiev.Filter;

import com.azuiev.Books.Book;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lera on 28.09.2015.
 */
public class FilterByPeriod implements Filter {
    public List<Book> books = new LinkedList<Book>();
    private Date start, end;
    private FilterByCity filter;

    FilterByPeriod(FilterByCity filter,Date start, Date end) {
        this.filter = filter;
        this.start = start;
        this.end = end;
    }

    @Override
    public List<Book> selectBooks() {
        books = filter.selectBooks();
        for (Book book : books) {
            if (!book.isFree(start, end)) {
                books.remove(book);
            }
        }
        return books;
    }
}
