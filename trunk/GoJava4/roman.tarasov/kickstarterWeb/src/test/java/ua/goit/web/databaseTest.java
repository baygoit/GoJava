package ua.goit.web;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.goit.web.model.dao.IDao;
import ua.goit.web.model.dao.KickstarterException;

public class databaseTest {
	ApplicationContext app;

	@Before
	public void setUp() {
		app = new ClassPathXmlApplicationContext("application-context.xml");

	}
	@Test
	public void test() {
		IDao dao =(IDao) app.getBean("DDao");
		try {
			
			System.out.println(dao.getRandomQuote().getQuote());
		} catch (KickstarterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
