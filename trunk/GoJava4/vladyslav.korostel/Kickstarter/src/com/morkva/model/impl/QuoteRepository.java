package com.morkva.model.impl;

import com.morkva.entities.Category;
import com.morkva.entities.Quote;
import com.morkva.model.Repository;

import java.util.*;

/**
 * Created by vladyslav on 17.05.15.
 */
public class QuoteRepository implements Repository<Quote> {

    Quote[] quotes;

    public QuoteRepository(Quote[] quotes) {
        this.quotes = quotes;
    }

    public QuoteRepository() {
        this.quotes = new Quote[0];
    }

    @Override
    public Quote getById(int id) {
        if (quotes.length == 0) {
            return null;
        } else {
            int searchResult = search(id);
            return quotes[searchResult];
        }
    }

    @Override
    public Quote findByName(String name) {
        Quote result = null;
        for (Quote quote : quotes) {
            if (quote.getValue().equals(name)) {
                result = quote;
            }
        }
        return result;
    }

    @Override
    public Quote getByIndex(int index) {
        if (quotes.length == 0) {
            return null;
        } else {
            return quotes[index];
        }
    }

    @Override
    public boolean add(Quote object) {
        int searchResult = search(object.getId());
        if (searchResult < 0) {
            Quote[] temp = Arrays.copyOf(quotes, quotes.length + 1);
            temp[temp.length - 1] = object;
            this.quotes = temp;
            sort();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(Quote object) {
        int searchResult = search(object.getId());
        if (searchResult > 0) {
            System.arraycopy(quotes, searchResult + 1, quotes, searchResult, quotes.length - 1 - searchResult);
            quotes = Arrays.copyOf(quotes, quotes.length - 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Quote object) {
        int searchResult = search(object.getId());
        if (searchResult > 0) {
            quotes[searchResult] = object;
            sort();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return quotes.length;
    }

    @Override
    public Quote[] getAll() {
        if (quotes.length == 0) {
            return null;
        } else {
            return quotes;
        }
    }

    private int search(int id) {
        return Arrays.binarySearch(quotes, id);
    }

    private void sort() {
        Arrays.sort(quotes, (o1, o2) -> o1.compareTo(o2.getId()));
    }
}
