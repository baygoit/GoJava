package ua.dborisenko.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void mappingTest() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Category category = new Category();
        category.setName("testname");
        session.save(category);
        tx.commit();
        session.flush();
        session.close();

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Query query = session.createQuery("FROM Category");
        List<Category> resultList = query.list();
        Category resultCategory = resultList.get(0);
        tx.commit();
        session.flush();
        session.close();
        assertThat(resultCategory.getName(), is("testname"));
    }

}
