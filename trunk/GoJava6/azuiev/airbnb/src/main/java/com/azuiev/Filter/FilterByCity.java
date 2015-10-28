package com.azuiev.filter;

import com.azuiev.model.Apartment;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lera on 28.09.2015.
 */
public class FilterByCity implements Filter {
    private List<Apartment> books = new LinkedList<Apartment>();
    private String pattern;
    FilterByCity(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public List<Apartment> selectBooks() {
        LinkedList<Apartment> all = new LinkedList<Apartment>(Apartment.getApartments());
        for (Apartment book : all) {
            if (pattern.equals(book.getCity())) {
                books.add(book);
            }
        }
        return books;
    }
}
