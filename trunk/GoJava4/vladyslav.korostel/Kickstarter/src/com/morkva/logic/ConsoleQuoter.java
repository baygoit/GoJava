package com.morkva.logic;

import com.morkva.entities.Quote;
import com.morkva.model.Repository;

import java.util.Random;

/**
 * Created by vladyslav on 30.04.15.
 */
public class ConsoleQuoter implements Quoter<String> {

    private Repository<Quote> quotesRepository;

    public ConsoleQuoter(Repository<Quote> quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    @Override
    public void showQuote() {
        System.out.println(quotesRepository.getByIndex(new Random().nextInt(quotesRepository.size())).toString());
    }
}
