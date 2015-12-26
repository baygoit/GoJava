package ua.com.goit.gojava7.kickstarter.dao.jdbc.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static void configure(String pathToFile) {
		if (sessionFactory == null) {
			try {
				sessionFactory = new Configuration().configure(pathToFile).buildSessionFactory();
			} catch (Throwable ex) {
				System.err.println("Initial SessionFactory creation failed." + ex);
				throw new ExceptionInInitializerError(ex);
			};
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> getList(String queryText, Object...args) {
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery(queryText);
		appendParametersToQuery(query, args);
		List<T> list = query.list();
    	session.close();
    	return list;
	}
	
	public static <T> T get(String queryText, Object...args) {
		T result = null;
		List<T> list = getList(queryText, args);
		if (!list.isEmpty()) {
			result = list.get(0);
		}
    	return result;
	}
	
	public static void executeUpdate(String queryText, Object...args) {
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery(queryText);
		appendParametersToQuery(query, args);
		query.executeUpdate();
		session.close();
	}

	private static void appendParametersToQuery(Query query, Object... args) {
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i, args[i]);
		}
	}

	public static <T> void save(List<T> elements) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		for (T item : elements) {
			session.save(item);
		}
		tx.commit();
		session.close();
	}

	public static <T> void save(T element) {
		List<T> list = new ArrayList<>();
		list.add(element);
		save(list);
	}
}
