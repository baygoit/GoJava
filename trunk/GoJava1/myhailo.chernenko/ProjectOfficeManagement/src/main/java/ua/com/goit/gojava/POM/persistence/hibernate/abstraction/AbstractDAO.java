package ua.com.goit.gojava.POM.persistence.hibernate.abstraction;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import ua.com.goit.gojava.POM.persistence.POMPersistenceException;
import ua.com.goit.gojava.POM.persistence.hibernate.HibernateUtil;
import ua.com.goit.gojava.POM.services.Paginator;

public abstract class AbstractDAO<T> {
	
	private Class<T> classT; 
	protected abstract String getClassName(); 
	protected abstract Logger getLog();
	protected abstract T getNewObject();
	
	public AbstractDAO(Class<T> classT) {
		this.classT = classT;
	}
	
	protected Session getSession() {
		//return sessionFactory.getCurrentSession();
		return HibernateUtil.getSessionFactory().openSession();
	}

	protected void closeSession(Session session) {
		if (session != null && session.isOpen()) {
            session.close();
        }
	}

	public T create() throws POMPersistenceException {

		T newObject = null;
		
		Session session = getSession();
		try {

			newObject = getNewObject();
			session.beginTransaction();
            session.save(newObject);
            session.getTransaction().commit();
            
		} catch (HibernateException | NullPointerException e) {
			getLog().error("Could not create new "+getClassName()+": "+e.getMessage(), e);
			throw new POMPersistenceException("Could not create new "+getClassName()+": "+e.getMessage() , e);
		} finally {
			closeSession(session);
 		}
		
		return newObject;
	
	}
	
	public T create(T newObject) throws POMPersistenceException {

		Session session = getSession();
		
		try {

			session.beginTransaction();
            session.save(newObject);
            session.getTransaction().commit();
            
		} catch (HibernateException | NullPointerException e) {
			getLog().error("Could not create new "+getClassName()+": "+e.getMessage(), e);
			throw new POMPersistenceException("Could not create new "+getClassName()+": "+e.getMessage() , e);
		} finally {
			closeSession(session);
 		}
		
		return newObject;	
	}
	
	public List<T> retrieveAll() throws POMPersistenceException {

		Session session = getSession();
		
		try {
			
			@SuppressWarnings("unchecked")
			List<T> resultList = session.createCriteria(classT).list();
			return resultList;	
			
		} catch (HibernateException e) {
			getLog().error("Could not retrieve all "+getClassName()+"s: "+e.getMessage(), e);
			throw new POMPersistenceException("Could not retrieve all "+getClassName()+"s: "+e.getMessage(), e);
		} finally {
			closeSession(session);
	 	}		
		
	}
	
	public List<T> retrieveAll(Paginator paginator) throws POMPersistenceException {

		Session session = getSession();
		
		try {
			
			Criteria criteria = session.createCriteria(classT);
			Long countRows =  (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
			paginator.setTotal(countRows.intValue());
			
			criteria = session.createCriteria(classT);
			criteria.setFirstResult(paginator.getFirstResult()-1);
			criteria.setMaxResults(paginator.getMaxResults());
			@SuppressWarnings("unchecked")
			List<T> resultList = criteria.list();
			
			return resultList;	
			
		} catch (HibernateException e) {
			getLog().error("Could not retrieve all "+getClassName()+"s: "+e.getMessage(), e);
			throw new POMPersistenceException("Could not retrieve all "+getClassName()+"s: "+e.getMessage(), e);
		} finally {
			closeSession(session);
	 	}		
		
	}
	
	public T retrieveById(Long id) throws POMPersistenceException {

		Session session = getSession();  
		try {
			
			@SuppressWarnings("unchecked")
			T result = (T) session.get(classT, id);
			return result;
			
		} catch (HibernateException e) {
			getLog().error("Could not retrieve "+getClassName()+" by ID: "+e.getMessage(), e);
			throw new POMPersistenceException("Could not retrieve "+getClassName()+" by ID: "+e.getMessage() , e);
		} finally {
			closeSession(session);
	    }
	}

	public void update(T tObject) throws POMPersistenceException {

		Session session = getSession();
		try {
			
			session.beginTransaction();
            session.update(tObject);
            session.getTransaction().commit();
            
        } catch (HibernateException | NullPointerException e) {
			getLog().error("Could not update "+getClassName()+": "+e.getMessage(), e);
			throw new POMPersistenceException("Could not update "+getClassName()+": "+e.getMessage(), e);
		} finally {
			closeSession(session);
	    }
	}
	
	public void delete(T tObject) throws POMPersistenceException {

		Session session = getSession();
		try {
			
			session.beginTransaction();
            session.delete(tObject);
            session.getTransaction().commit();
            
        } catch (HibernateException | NullPointerException e) {
			getLog().error("Could not delete "+getClassName()+": "+e.getMessage(), e);
			throw new POMPersistenceException("Could not delete "+getClassName()+": "+e.getMessage(), e);
		} finally {
			closeSession(session);
	    }
	}

}
