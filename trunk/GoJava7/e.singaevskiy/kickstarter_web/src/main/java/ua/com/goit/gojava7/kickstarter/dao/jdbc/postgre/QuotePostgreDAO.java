package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.HibernateUtil;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@Repository
public class QuotePostgreDAO implements QuoteDAO {
	@Autowired
	private HibernateUtil hiberUtil;

    @Override
    public List<Quote> getAll() {
    	return hiberUtil.getList("from Quote");
    }

    @Override
    public Quote get(int index) {
		return hiberUtil.get("from Quote where id = ?", index);
    }

    @Override
    public void add(Quote element) {
    	hiberUtil.save(element);
    }

    @Override
    public void addAll(List<Quote> elements) {    
    	hiberUtil.save(elements);
    }

    @Override
    public void clear() {
    	hiberUtil.executeUpdate("delete Quote");
    }

}
