package ua.com.goit.gojava.kickstarter.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDao {
	@Autowired
	 private SessionFactory sessionFactory;
	
	
	
	Session getCurrentSession(){
		try{
			return sessionFactory.getCurrentSession();
		}catch(HibernateException e){
			return sessionFactory.openSession();
		}
	}
}
