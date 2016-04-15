package ua.dborisenko.kickstarter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Quote;

@Repository
public class QuoteDao {

    public Quote getRandom() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
		return session.get(Quote.class, 1);
    }
}
