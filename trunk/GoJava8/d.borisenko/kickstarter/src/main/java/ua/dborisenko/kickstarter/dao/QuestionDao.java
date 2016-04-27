package ua.dborisenko.kickstarter.dao;

import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

@Repository
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class QuestionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public void add(Question question) {
        Session session = sessionFactory.getCurrentSession();
        session.save(question);
        session.flush();
    }

    public void getAllForProject(Project project) {
        Session session = sessionFactory.getCurrentSession();
        session.lock(project, LockMode.NONE);
        Hibernate.initialize(project.getQuestions());
    }

}
