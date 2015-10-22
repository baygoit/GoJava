package com.azuiev.filter;

import com.azuiev.model.Apartment;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lera on 28.09.2015.
 */
public class FilterByPeriod implements Filter {
    public List<Apartment> books = new LinkedList<Apartment>();
    private Date start, end;
    private FilterByCity filter;

    FilterByPeriod(FilterByCity filter,Date start, Date end) {
        this.filter = filter;
        this.start = start;
        this.end = end;
    }

    @Override
    public List<Apartment> selectBooks() {
        books = filter.selectBooks();
        for (Apartment book : books) {
            if (!book.isFree(start, end)) {
                books.remove(book);
            }
        }
        return books;
    }
}
