package ua.dborisenko.kickstarter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.dborisenko.kickstarter.domain.Investment;

@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
public class InvestmentDao {

    @Autowired
        private SessionFactory sessionFactory;

    public void add(Investment investment) {
        Session session = sessionFactory.getCurrentSession();
        session.save(investment);
        session.flush();
    }
}
