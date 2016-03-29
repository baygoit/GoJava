package com.sandarovich.kickstarter.dao.quote;

import com.sandarovich.kickstarter.domain.Quote;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Quote Dao Memory.
 */

public class QuoteDaoMemoryImpl implements QuoteDao {

    protected List<Quote> quotes;

    public QuoteDaoMemoryImpl() {
        fillQuotas();
    }

    void fillQuotas() {
        quotes = new ArrayList<>();
        quotes.add(new Quote("Mr SS", "Every big journey begins with a small step"));
        quotes.add(new Quote("Mr SS", "No pain, no gain"));
        quotes.add(new Quote("Mr SS", "Excellence across the board"));
    }

    Quote getQuotaById(int quotaIndex) {
        return (quotaIndex >= 0 && quotaIndex <= quotes.size()) ?
                quotes.get(quotaIndex) :
                quotes.get(0);
    }

    public Quote getRandomQuota() {
        int quotaIndex = new Random().nextInt(quotes.size());
        return getQuotaById(quotaIndex);
    }
}
