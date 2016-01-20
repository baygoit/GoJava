package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDAO;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@Repository
public class QuotePostgreDAO implements QuoteDAO {
	@PersistenceContext
	private EntityManager entityManager;

    @Override
    public List<Quote> getAll() {
    	return entityManager.createNamedQuery("Quote.getAll", Quote.class).getResultList();
    }

    @Override
    public Quote get(Long index) {
		return entityManager.find(Quote.class, index);
    }

    @Override
    @Transactional
    public void add(Quote element) {
    	entityManager.persist(element);
    }

    @Override
    @Transactional
    public void addAll(List<Quote> elements) {  
    	elements.forEach(entityManager::persist);
    }

    @Override
    @Transactional
    public void clear() {
    	entityManager.createNamedQuery("Quote.removeAll").executeUpdate();
    }

	@Override
	public Quote getRandom() {
		TypedQuery<Quote> createNamedQuery = entityManager.createNamedQuery("Quote.getRandom", Quote.class);
        createNamedQuery.setMaxResults(1);
		return createNamedQuery.getSingleResult();
	}

}
