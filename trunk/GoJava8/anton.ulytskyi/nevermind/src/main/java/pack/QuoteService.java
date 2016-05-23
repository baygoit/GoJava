package pack;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


    @Repository
	public class QuoteService {
	   
	  // An EntityManager will be automatically injected from EntityManagerFactory setup on
	  // spring-context.xml
	  @PersistenceContext
	  private EntityManager em;
	   
	  // Since we've setup <tx:annotation-config> and transaction manager on spring-context.xml,
	  // any bean method annotated with @Transactional will cause Spring to magically call
	  // begin() and commit() at the start/end of the method. If exception occurs it will also
	  // call rollback()
	  
	  public List<Quote> getAll() {
	    List<Quote> result = em.createQuery("SELECT q FROM Quote q", Quote.class).getResultList();
	    return result;
	  }
	   
	
	  public void add(Quote quote) {
		  Quote newQuote = em.merge(quote);
	    em.persist(newQuote);
	  }
	}