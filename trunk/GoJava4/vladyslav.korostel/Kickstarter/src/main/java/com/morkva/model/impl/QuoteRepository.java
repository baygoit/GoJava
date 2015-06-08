package com.morkva.model.impl;

import com.morkva.entities.Quote;
import com.morkva.model.IRepository;

import java.util.*;

/**
 * Created by vladyslav on 17.05.15.
 */
public class QuoteRepository implements IRepository<Quote> {

    List<Quote> quotes;

    public QuoteRepository(List<Quote> dataSource) {
        this.quotes = dataSource;
    }

    public QuoteRepository() {
        this.quotes = new ArrayList<>();
    }

    @Override
    public Quote getById(int id) {
        if (quotes.size() == 0) {
            return null;
        } else {
            int searchResult = search(id);
            return quotes.get(searchResult);
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
        if (quotes.size() == 0) {
            return null;
        } else {
            return quotes.get(index);
        }
    }

    @Override
    public boolean add(Quote object) {
        int searchResult = search(object.getId());
        if (searchResult < 0) {
            quotes.add(object);
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
            quotes.remove(searchResult);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Quote object) {
        int searchResult = search(object.getId());
        if (searchResult > 0) {
            quotes.set(searchResult, object);
            sort();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return quotes.size();
    }

    @Override
    public List<Quote> getAll() {
        if (quotes.size() == 0) {
            return null;
        } else {
            return quotes;
        }
    }

    private int search(int id) {
        return Collections.binarySearch(quotes, id);
    }

    private void sort() {
        Collections.sort(quotes, (o1, o2) -> o1.compareTo(o2.getId()));
    }
}
