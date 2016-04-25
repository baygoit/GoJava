package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.HibernateUtil;
import hibernate.Quote;

public class DAOQuote {

	public String showQuote() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Long count = ((Long) session.createQuery("select count(*) from Quote")
				.uniqueResult());
		Integer totalQuotes = count.intValue();

		int dice = (int) (Math.random() * totalQuotes) + 1;
		String quote = session.get(Quote.class, dice).getQuote();

		session.close();
		sessionFactory.close();

		return quote;

		/**
		 * try { Class.forName("com.mysql.jdbc.Driver"); } catch
		 * (ClassNotFoundException e) { e.printStackTrace(); } try ( Connection
		 * myConn = (Connection) DriverManager .getConnection(
		 * "jdbc:mysql://www.db4free.net:3306/kickbase?autoReconnect=true&useSSL=false"
		 * , "author", "xzxzzxzxcaa"); Statement myStmt = (Statement)
		 * myConn.createStatement()) { ResultSet myRs = myStmt
		 * .executeQuery("SELECT * FROM quotes ORDER BY RAND() limit 1");
		 * 
		 * myRs.next(); return myRs.getString("quotes"); } catch (Exception exc)
		 * { exc.printStackTrace(); }
		 * 
		 * return "Please call to Your developer";
		 */
	}
}
