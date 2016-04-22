package ua.dborisenko.kickstarter.dao;

import java.util.Set;
import java.util.TreeSet;

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

    public void add(Project project) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(project);
        tx.commit();
    }

    public void getAllForCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Project where category_id = " + category.getId());
        Set<Project> projects = new TreeSet<Project>(query.list());
        tx.commit();
        category.setProjects(projects);
    }

    public Project getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Project where id = " + id);
        Project project = (Project) query.list().get(0);
        tx.commit();
        return project;
    }
}
