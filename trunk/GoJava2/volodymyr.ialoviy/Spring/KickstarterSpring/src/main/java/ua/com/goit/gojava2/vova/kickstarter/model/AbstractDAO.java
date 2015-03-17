package ua.com.goit.gojava2.vova.kickstarter.model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO {

	// @Autowired
	// private DataSource dataSource;

	@Autowired
	protected SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public Session getSession() throws HibernateException {
	Session sess = null;       
	   try {         
	       sess = sessionFactory.getCurrentSession();  
	   } catch (org.hibernate.HibernateException he) {  
	       sess = sessionFactory.openSession();     
	   }             
	   return sess;
	} 

//	protected Connection getConnection() throws SQLException {
//
//		sessionFactory.getCurrentSession().
//		
//		
//		return sessionFactory.getSessionFactoryOptions().;
//	}

}