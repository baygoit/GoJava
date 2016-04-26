package ua.dborisenko.kickstarter.dao;

import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import ua.dborisenko.kickstarter.domain.Project;

@Repository
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class RewardDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void getAllForProject(Project project) {
        try (Session session = sessionFactory.openSession()) {
            session.lock(project, LockMode.NONE);
            Hibernate.initialize(project.getRewards());
        }
    }
}
