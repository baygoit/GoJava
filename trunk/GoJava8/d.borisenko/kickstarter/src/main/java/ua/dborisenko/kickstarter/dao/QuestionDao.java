package ua.dborisenko.kickstarter.dao;

import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

@Repository
public class QuestionDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(Question question) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(question);
        tx.commit();
        session.flush();
        session.close();
    }

    public void getAllForProject(Project project) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.lock(project, LockMode.NONE);
        Hibernate.initialize(project.getQuestions());
        tx.commit();
        session.close();
    }

}
