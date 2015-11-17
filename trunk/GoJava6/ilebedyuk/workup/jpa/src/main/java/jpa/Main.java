package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Игорь on 14.11.2015.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        List<User> users = em.createQuery("select p from User p", User.class).getResultList();
        for (User user : users) {
            System.out.println(user);
        }

        em.close();
        emf.close();
    }
}
