package com.tyomsky.kickstarter.service;

import com.tyomsky.kickstarter.dao.QuoteDAO;
import com.tyomsky.kickstarter.domain.Quote;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

import static java.lang.Math.max;

public class QuoteServiceImpl implements QuoteService {

    private QuoteDAO quoteDAO;

    public QuoteServiceImpl(QuoteDAO quoteDAO) {
        this.quoteDAO = quoteDAO;
    }

    @Transactional
    public Quote getRandomQuote() {
        return quoteDAO.getRandom();
    }

}
