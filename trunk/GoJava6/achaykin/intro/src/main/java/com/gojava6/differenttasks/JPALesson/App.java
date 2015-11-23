package com.gojava6.differenttasks.JPALesson;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @Autor Andrey Chaykin
 * @Since 14.11.2015
 */
public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, 1);
        System.out.println(user);
       em.close();
        emf.close();
    }
}
