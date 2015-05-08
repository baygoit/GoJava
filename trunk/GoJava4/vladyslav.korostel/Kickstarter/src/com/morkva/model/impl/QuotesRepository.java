package com.morkva.model.impl;

import com.morkva.entities.Quote;
import com.morkva.entities.utils.ID;
import com.morkva.model.Repository;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by vladyslav on 30.04.15.
 */
public class QuotesRepository implements Repository<Quote> {

    private Quote[] quotes;

    public QuotesRepository(Quote[] quotes) {
        this.quotes = quotes;
        sort();
    }

    @Override
    public Quote getByIndex(int index) {
        return quotes[index];
    }

    @Override
    public Quote getById(ID id) {
        int searchResult = search(id);
        return quotes[searchResult];
    }

    @Override
    public boolean add(Quote quote) {
        int searchResult = search(quote.getId());
        if (searchResult < 0) {
            Quote[] temp = Arrays.copyOf(quotes, quotes.length + 1);
            temp[temp.length - 1] = quote;
            this.quotes = temp;
            sort();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(Quote quote) {
        int searchResult = search(quote.getId());
        if (searchResult > 0) {
            System.arraycopy(quotes, searchResult + 1, quotes, searchResult, quotes.length - 1 - searchResult);
            quotes = Arrays.copyOf(quotes, quotes.length - 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Quote quote) {
        int searchResult = search(quote.getId());
        if (searchResult > 0) {
            quotes[searchResult] = quote;
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

    private int search(ID id) {
        return Arrays.binarySearch(quotes, id);
    }

    private void sort() {
        Arrays.sort(quotes, new Comparator<Quote>() {
            @Override
            public int compare(Quote o1, Quote o2) {
                ID id1 = o1.getId();
                ID id2 = o2.getId();
                return id1.compareTo(id2);
            }
        });
    }
}
