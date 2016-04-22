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
import ua.dborisenko.kickstarter.domain.Question;

@Repository
public class QuestionDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(Question question) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(question);
        tx.commit();
    }

    public void getAllForProject(Project project) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Question where project_id = " + project.getId());
        Set<Question> questions = new TreeSet<Question>(query.list());
        tx.commit();
        project.setQuestions(questions);
    }

}
