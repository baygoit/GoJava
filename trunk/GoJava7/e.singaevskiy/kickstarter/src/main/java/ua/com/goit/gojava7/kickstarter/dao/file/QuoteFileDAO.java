package ua.com.goit.gojava7.kickstarter.dao.file;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.util.FileDAO;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteFileDAO extends FileDAO<Quote> implements QuoteDAO {

    public QuoteFileDAO() {
        super(Quote.class);
    }

    public QuoteFileDAO(String pathToFile) {
        super(Quote.class, pathToFile);
    }

}
