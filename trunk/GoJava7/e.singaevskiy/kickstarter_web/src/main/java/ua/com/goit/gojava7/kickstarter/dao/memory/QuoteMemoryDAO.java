package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.util.MemoryDAO;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteMemoryDAO extends MemoryDAO<Quote> implements QuoteDAO{

    public QuoteMemoryDAO(List<Quote> dataSource) {
        super(dataSource);
    }

}
