package com.kickstarter.dao.Impl;

import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kickstarter.dao.Interfaces.QuoteDao;
import com.kickstarter.model.Quote;

@Repository
public class QuoteDaoImpl implements QuoteDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Quote get() {

		Query query = entityManager.createQuery("select count(q) as cnt from Quote q");
		Long count = (Long) query.getSingleResult();

		Random random = new Random();
		int number = random.nextInt(count.intValue());

		Query selectQuery = entityManager.createQuery("select q from Quote q");
		selectQuery.setFirstResult(number);
		selectQuery.setMaxResults(1);

		Quote quote = (Quote) selectQuery.getSingleResult();

		return quote;
	}

}

/*
 * @Autowired private BasicDataSource dbCon;
 * 
 * public BasicDataSource getDbCon() { return dbCon; }
 * 
 * public void setDbCon(BasicDataSource dbCon) { this.dbCon = dbCon; }
 */
// public Quote get() {
// ResultSet rs = null;
// PreparedStatement pStatement = null;
// List<Quote> list = new ArrayList<>();
//
// try (Connection conection = dbCon.getConnection()) {
// pStatement = conection.prepareStatement("select author,quote from quotes");
// rs = pStatement.executeQuery();
//
// while (rs.next()) {
// Quote quote = new Quote();
// quote.setAuthor(rs.getString("author"));
// quote.setQuoteText(rs.getString("quote"));
// list.add(quote);
// }
// } catch (SQLException e) {
// System.out.println("Quote MySql connection problem");
// }
// return list.get((int) (Math.random() * list.size()));
// }
// }
