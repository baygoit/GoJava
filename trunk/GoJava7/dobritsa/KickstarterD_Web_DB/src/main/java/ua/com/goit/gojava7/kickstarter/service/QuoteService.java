package ua.com.goit.gojava7.kickstarter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.model.Quote;

import java.util.Random;

@Repository
public class QuoteService {

    private static final Logger log = LoggerFactory.getLogger(QuoteService.class);

    @Autowired
    private QuoteDao quoteDao;

    public Quote getRandomQuote() {
        log.info("<Quote> getRandomQuote()...");

        Random rnd = new Random();
        int size = quoteDao.size().intValue();
        Long rand = Long.valueOf(rnd.nextInt(size));

        return quoteDao.get(rand);
    }
}
