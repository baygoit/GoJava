package kickstarter.service;

import java.util.List;

import kickstarter.dao.QuoteDAO;
import kickstarter.domain.Quote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("QuoteService")
@Transactional
public class QuoteService {
	@Autowired
	protected QuoteDAO dao;

	public void setDao(QuoteDAO dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	public List<Quote> findAll() {
		return this.dao.findAll();
	}
	
}
