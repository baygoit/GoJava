package belskii.artem.kickstarter.mvc.model;

import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

import belskii.artem.kickstarter.dao.quote.Quote;

public class QuoteModelHiber {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	private int getMaxId() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session
			    .createCriteria(Quote.class)
			    .setProjection(Projections.max("id"));
			Integer maxId = (Integer)criteria.uniqueResult();
			session.close();
			if (maxId==null){
				maxId=0;
			}
			return maxId;
	}
	
	public String getRandomQuote() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Random random = new Random();
		int randomId  = random.nextInt(this.getMaxId());
		if(randomId==0){
			randomId=1;
		}
		Quote randomquote=session.get(Quote.class, randomId);
		session.close();
		return randomquote.getQuote();

	}

	public void addQuote(String text) {
		Quote quote = new Quote(text);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(quote);
		session.getTransaction().commit();
		session.close();
	}

	public void initDemoDB() {
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		session.createSQLQuery("DROP TABLE IF EXISTS QUOTE").executeUpdate();
//		session.getTransaction().commit();
//		session.close();
//		
//		this.addQuote("Demo Quote");
	}

}
