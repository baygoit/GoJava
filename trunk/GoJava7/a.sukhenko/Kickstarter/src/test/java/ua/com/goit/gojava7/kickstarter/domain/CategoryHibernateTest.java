package ua.com.goit.gojava7.kickstarter.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoryHibernateTest{
    private SessionFactory sessionFactory;
    
    @Before
    public void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        // configures settings from hibernate.cfg.xml
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            // The registry would be destroyed by the SessionFactory, but we had
            // trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
    @After
    public void tearDown() throws Exception {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
    
    @Test
    public void test() {
        // Lets add 2 categories
      org.hibernate.Session session = sessionFactory.openSession();
      session.beginTransaction();
      
      Category category = new Category();
      category.setCategoryName("Category First");
      
      Category category2 = new Category();
      category2.setCategoryName("Category SEcond");
      
      session.save(category);
      session.save(category2);
      
      session.getTransaction().commit();
      session.close();
      
      session = sessionFactory.openSession();
      session.beginTransaction();
      List<Category> categories = (List<Category>)session.createQuery("from Category").list();
      for (Category tempCategory : categories) {
        System.out.println(tempCategory);
    }
      session.close();
      
      
    }

}
