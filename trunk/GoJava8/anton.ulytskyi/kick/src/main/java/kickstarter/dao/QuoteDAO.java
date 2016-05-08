package kickstarter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import kickstarter.domain.Quote;

import org.springframework.stereotype.Repository;

@Repository
public class QuoteDAO {

	@PersistenceContext
    protected EntityManager emf;
	
	@SuppressWarnings("unchecked")
	public List<Quote> findAll() {
		
		return emf.createQuery("from quotes q").getResultList();
			
	}

}
