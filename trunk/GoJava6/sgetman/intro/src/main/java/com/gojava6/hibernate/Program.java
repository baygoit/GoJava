package com.gojava6.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Program {

    public static void main(String[] args) {
        System.out.println("Hello world");

        PopulateSampleData();

        Session session1 = HibernateUtilities.getSessionFactory().openSession();
        Session session2 = HibernateUtilities.getSessionFactory().openSession();
        //session1.beginTransaction();

        //Query query = session1.getNamedQuery("AllGoalAlerts");
        //Query query = session1.createQuery("select new com.simpleprogrammer.UserTotal(user.name, user.proteinData.total) " +
        //		"from User user");

        Transaction tx1 = session1.beginTransaction();
        ProteinData load = (ProteinData)session1.load(ProteinData.class, 1);
        //((ProteinData)load).setTotal(50);
        tx1.commit();
        session1.close();

        Transaction tx2 = session2.beginTransaction();
        ProteinData proteinData = (ProteinData) session2.load(ProteinData.class, 1);

        tx2.commit();
        session2.close();




        session1 = HibernateUtilities.getSessionFactory().openSession();
        tx1 = session1.beginTransaction();

        System.out.println(session1.load(ProteinData.class, 1));
        tx1.commit();

        //session1.getTransaction().commit();
        session1.close();

        HibernateUtilities.getSessionFactory().close();
    }

    private static void PopulateSampleData() {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.beginTransaction();

        User joe = CreateUser("Joe", 500, 50, "Good job", "You made it!");
        session.save(joe);

        User bob = CreateUser("Bob", 300, 20, "Taco time!");
        session.save(bob);

        User amy = CreateUser("Amy", 250, 200, "Yes!!!");
        session.save(amy);
        session.getTransaction().commit();
        session.close();
    }

    private static User CreateUser(String name, int goal, int total, String... alerts) {
        User user = new User();
        user.setName(name);
        user.getProteinData().setGoal(goal);
        user.addHistory(new UserHistory(new Date(), "Set goal to " + goal));
        user.getProteinData().setTotal(total);
        user.addHistory(new UserHistory(new Date(), "Set total to " + total));
        for (String alert : alerts) {
            user.getGoalAlerts().add(new GoalAlert(alert));
        }

        return user;
    }

}
