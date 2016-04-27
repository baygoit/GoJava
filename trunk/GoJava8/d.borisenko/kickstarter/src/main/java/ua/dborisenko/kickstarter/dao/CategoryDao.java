package ua.dborisenko.kickstarter.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Project;

@Repository
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class CategoryDao {

    private static final String GET_BY_PROJECT_ID_HQL = "select p.category from Project p inner join p.category where p.id = :id";
    private static final String GET_ALL_HQL = "from Category order by name";
    private static final String GET_BY_ID_HQL = "from Category where id = :id";
    @Autowired
    private SessionFactory sessionFactory;

    public Category getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(GET_BY_ID_HQL);
        query.setInteger("id", id);
        Category category = (Category) query.list().get(0);
        return category;
    }

    @SuppressWarnings("unchecked")
    public List<Category> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(GET_ALL_HQL);
        List<Category> categories = query.list();
        return categories;

    }

    public Category getByProject(Project project) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(GET_BY_PROJECT_ID_HQL);
        query.setInteger("id", project.getId());
        Category category = (Category) query.list().get(0);
        return category;
    }
}
