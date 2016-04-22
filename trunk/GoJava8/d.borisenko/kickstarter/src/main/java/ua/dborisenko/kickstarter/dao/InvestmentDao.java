package ua.dborisenko.kickstarter.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;

@Repository
public class InvestmentDao {

    @Autowired
    private SessionFactory sessionFactory;

    void getAllForProject(Project project) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Investment where project_id = " + project.getId());
        Set<Investment> investments = new HashSet<Investment>(query.list());
        tx.commit();
        project.setInvestments(investments);
    }

    public void add(Investment investment) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(investment);
        tx.commit();
    }
}
