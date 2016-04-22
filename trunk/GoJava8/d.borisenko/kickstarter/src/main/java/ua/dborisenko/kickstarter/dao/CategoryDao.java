package ua.dborisenko.kickstarter.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Project;

@Repository
public class CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(Category category) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(category);
        tx.commit();
    }

    public Category getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Category where id = " + id);
        Category category = (Category) query.list().get(0);
        tx.commit();
        return category;
    }

    public List<Category> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Category order by name");
        List<Category> categories = query.list();
        tx.commit();
        return categories;
    }

    public Category getByProject(Project project) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session
                .createQuery("select p.category from Project p inner join p.category where p.id = " + project.getId());
        Category category = (Category) query.list().get(0);
        tx.commit();
        return category;
    }
}
