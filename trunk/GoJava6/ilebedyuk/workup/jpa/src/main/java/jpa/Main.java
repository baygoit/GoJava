package jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Игорь on 14.11.2015.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        Dao dao = context.getBean("Dao", Dao.class);
        //User user = new User();
        //user.setName("Kol");


        List<User> users = dao.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

    }
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
//        EntityManager em = emf.createEntityManager();
//
//        List<User> users = em.createQuery("select p from User p", User.class).getResultList();
//        for (User user : users) {
//            System.out.println(user);
//        }
//
//        em.close();
//        emf.close();
//    }
}
