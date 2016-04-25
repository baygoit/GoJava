package ua.dborisenko.kickstarter.dao;

import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Project;

@Repository
public class ProjectDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void getAllForCategory(Category category) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.lock(category, LockMode.NONE);
        Hibernate.initialize(category.getProjects());
        tx.commit();
        session.close();
    }

    public Project getById(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Project where id = :id");
        query.setInteger("id", id);
        Project project = (Project) query.list().get(0);
        tx.commit();
        session.close();
        return project;
    }
}
