package com.tyomsky.kickstarter;

import com.tyomsky.kickstarter.dao.common.AbstractHibernateDao;
import com.tyomsky.kickstarter.domain.Category;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = "classpath:spring-test-config/application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class HibernateTest {

    @Autowired
    SessionFactory sessionFactory;

    @Test
    @Transactional
    @Rollback(false)
    public void testHibernate() {
        System.out.println(sessionFactory);
        Category category = new Category("category");
        Category category1 = new Category("category1");
        Category category3 = new Category("category");
        sessionFactory.getCurrentSession().persist(category);
        sessionFactory.getCurrentSession().persist(category1);
        sessionFactory.getCurrentSession().persist(category3);
    }


}
