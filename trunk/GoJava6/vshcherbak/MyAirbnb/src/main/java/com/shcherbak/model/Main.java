package com.shcherbak.model;

//import java.sql.*;
//import org.hibernate.Transaction;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) throws PersistenceException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "My_JPA" );

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //EntityTransaction tr = em.getTransaction();
        //tr.begin();
        try {
        /*Test first = new Test(0L, "next", "some", 43);
            em.persist(first);
            Test test = new Test();
            //test.setId(42);
            test.setName("Name");
        test.setText("Text");
        test.setData(100500);

            em.persist(test);*/
        /*Test one = em.find(Test.class, 10);
        System.out.println(one);*/
            //tr.commit();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
            emf.close();
        }

    }
/*        persistTest(new Test(0, "Test1", "Best", 248));
        Test test = findTest(1L);
        System.out.println("# " + test);
    }
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/airbnb", "root", "atmel");
    }

    private static void persistTest(Test test) throws SQLException {

        String query = "INSERT INTO test VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
            stmt.setLong(1, test.getId());
            stmt.setString(2, test.getName());
            stmt.setString(3, test.getText());
            stmt.setInt(4, test.getData());
            stmt.executeUpdate();
        }
    }

    private static Test findTest(Long id) throws SQLException {
        Test test = new Test();
        String query = "SELECT * FROM test WHERE ID = ?";
        try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                test.setId(rs.getInt("id"));
                test.setName(rs.getString("name"));
                test.setText(rs.getString("text"));
                test.setData(rs.getInt("data"));
            }
        }
        return test;
    }*/
}
