package ua.dborisenko.kickstarter.dao;

import org.hibernate.Hibernate;
import org.hibernate.LockMode;
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
public class ProjectDao {

    private static final String GET_BY_ID_HQL = "from Project where id = :id";
    @Autowired
    private SessionFactory sessionFactory;

    public void getAllForCategory(Category category) {
        try (Session session = sessionFactory.openSession()) {
            session.lock(category, LockMode.NONE);
            Hibernate.initialize(category.getProjects());
        }
    }

    public Project getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery(GET_BY_ID_HQL);
            query.setInteger("id", id);
            Project project = (Project) query.list().get(0);
            return project;
        }
    }
}
