package belskii.artem.kickstarter.dao.quote;

import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

public class QuoteDaoImplHiber implements QuoteDao {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	

	private int getNextId() {
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
			return maxId+1;
	}

	@Override
	public String getRandomQuote() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Random random = new Random();
		int randomId  = random.nextInt(this.getNextId()-1);
		if(randomId==0){
			randomId=1;
		}
		Quote randomquote=session.get(Quote.class, randomId);
		session.close();
		return randomquote.getQuote();

	}

	@Override
	public void addQuote(String text) {
		Quote quote = new Quote(this.getNextId(), text);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(quote);
		session.getTransaction().commit();
		session.close();
	}

	@Override
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
