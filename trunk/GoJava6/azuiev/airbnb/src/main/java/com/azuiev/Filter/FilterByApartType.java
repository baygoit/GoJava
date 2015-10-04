package com.azuiev.Filter;

import com.azuiev.Books.ApartType;
import com.azuiev.Books.Apartment;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lera on 28.09.2015.
 */
public class FilterByApartType implements Filter {
    public List<Apartment> books = new LinkedList<Apartment>();
    private ApartType apartType;
    private FilterByCity filter;

    FilterByApartType(FilterByCity filter, ApartType apartType) {
        this.filter = filter;
        this.apartType = apartType;
    }

    @Override
    public List<Apartment> selectBooks() {
        books = filter.selectBooks();
            for (Apartment book : books) {
                if (!apartType.equals(book.getApartType())) {
                    books.remove(book);
                }
            }
        return books;
    }
}
