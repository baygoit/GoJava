package com.kickstarter.dao.Impl;


import java.util.List;

//import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kickstarter.dao.interfaces.QuoteDao;
//import com.kickstarter.hibernate.HibernateUtil;
import com.kickstarter.model.Quote;

@Repository
public class QuoteDaoImpl implements QuoteDao {


	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional
	public Quote get() {

		Session session = sessionFactory.openSession();

		List<Quote> quotes = (List<Quote>) session.createQuery("from Quote q order by rand()").setMaxResults(1).list();
		if (quotes.isEmpty()) {
			return null;
		}

		Quote quote = quotes.get(0);

		session.close();

		return quote;

	}
}













/*	@Autowired
private BasicDataSource dbCon;

public BasicDataSource getDbCon() {
	return dbCon;
}

public void setDbCon(BasicDataSource dbCon) {
	this.dbCon = dbCon;
}*/
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
