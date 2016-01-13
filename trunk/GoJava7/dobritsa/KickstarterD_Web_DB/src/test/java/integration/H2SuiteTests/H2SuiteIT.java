package integration.H2SuiteTests;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        H2EmptyIT.class,
        H2FillerForIT.class,
        H2FullIT.class
})
public class H2SuiteIT {

    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void setUp() throws Exception {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate/hibernateTest.cfg.xml").build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @AfterClass
    public static void tearDown() throws Exception {
        if (sessionFactory != null) {
            System.out.println("---sessionFactory.close()---");
            sessionFactory.close();
        }
    }
}
