package ua.dborisenko.kickstarter.dao;

import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

@Repository
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class ProjectDao {

    private static final String GET_BY_ID_HQL = "from Project where id = :id";
    @Autowired
    private SessionFactory sessionFactory;

    public void getAllForCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.lock(category, LockMode.NONE);
        Hibernate.initialize(category.getProjects());
    }

    public Project getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(GET_BY_ID_HQL);
        query.setInteger("id", id);
        Project project = (Project) query.list().get(0);
        return project;
    }

    public void getRewards(Project project) {
        Session session = sessionFactory.getCurrentSession();
        session.lock(project, LockMode.NONE);
        Hibernate.initialize(project.getRewards());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public void addQuestion(Question question) {
        Session session = sessionFactory.getCurrentSession();
        session.save(question);
        session.flush();
    }

    public void getQuestions(Project project) {
        Session session = sessionFactory.getCurrentSession();
        session.lock(project, LockMode.NONE);
        Hibernate.initialize(project.getQuestions());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public void addInvestment(Investment investment) {
        Session session = sessionFactory.getCurrentSession();
        session.save(investment);
        session.flush();
    }
}
