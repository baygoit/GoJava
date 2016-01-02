package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.HibernateUtil;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuotePostgreDAO implements QuoteDAO {

    @Override
    public List<Quote> getAll() {
    	return HibernateUtil.getList("from Quote");
    }

    @Override
    public Quote get(int index) {
		return HibernateUtil.get("from Quote where id = ?", index);
    }

    @Override
    public void add(Quote element) {
    	HibernateUtil.save(element);
    }

    @Override
    public void addAll(List<Quote> elements) {    
    	HibernateUtil.save(elements);
    }

    @Override
    public void clear() {
        HibernateUtil.executeUpdate("delete Quote");
    }

}
