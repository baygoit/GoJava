package ua.com.goit.gojava.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO {
        
        @Autowired
        SessionFactory sessionFactory;

        Session getSession(){
                return sessionFactory.openSession();
        }

}