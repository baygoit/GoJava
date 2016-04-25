package ua.dborisenko.kickstarter.dao;

import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Project;

@Repository
public class RewardDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void getAllForProject(Project project) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.lock(project, LockMode.NONE);
        Hibernate.initialize(project.getRewards());
        tx.commit();
        session.close();
    }
}
