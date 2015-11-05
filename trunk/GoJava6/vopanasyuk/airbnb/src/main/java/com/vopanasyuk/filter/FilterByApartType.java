package com.vopanasyuk.filter;

import com.vopanasyuk.enums.ApartType;
import com.vopanasyuk.model.Apartment;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Hunky on 28.09.2015.
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