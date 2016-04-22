package ua.dborisenko.kickstarter.dao;

import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Reward;

@Repository
public class RewardDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(Reward reward) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(reward);
        tx.commit();
    }

    public void getAllForProject(Project project) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Reward where project_id = " + project.getId());
        Set<Reward> rewards = new TreeSet<Reward>(query.list());
        tx.commit();
        project.setRewards(rewards);
    }
}
