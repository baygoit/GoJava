package ua.dborisenko.kickstarter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Investment;

@Repository
public class InvestmentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(Investment investment) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(investment);
        tx.commit();
        session.flush();
        session.close();
    }
}
