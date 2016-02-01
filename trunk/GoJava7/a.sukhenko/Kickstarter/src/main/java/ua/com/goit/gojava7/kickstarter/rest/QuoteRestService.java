package ua.com.goit.gojava7.kickstarter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.com.goit.gojava7.kickstarter.dao.db.QuoteDao;
import ua.com.goit.gojava7.kickstarter.model.Quote;

@RestController
@RequestMapping("/rest")
public class QuoteRestService{

    @Autowired
    private QuoteDao quoteDao;
    
    
    @RequestMapping("/randomQuote")
    public Quote getQuote(){
        return quoteDao.getRandomQuote();
    }
    
}
