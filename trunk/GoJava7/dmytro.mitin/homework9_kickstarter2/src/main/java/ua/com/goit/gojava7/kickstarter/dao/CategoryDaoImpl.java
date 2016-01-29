package ua.com.goit.gojava7.kickstarter.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private SessionFactory sessionFactory;

    public CategoryDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Category> getCategories() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Category> categories = session.createCriteria(Category.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        transaction.commit();
        session.close();
        return categories;
    }

    @Override
    public void add(Category category) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(category);

        transaction.commit();
        session.close();
    }

    @Override
    public void update(Project project) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(project);

        transaction.commit();
        session.close();
    }

}
