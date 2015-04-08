package ua.com.sas.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.com.sas.dao.Categories;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-application-context.xml" })
public class CategoriesDAOTest extends CategoriesTest{

	
	@Autowired
	private Categories categoriesDAO;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	Categories getList() {
		return categoriesDAO;
	}
		
	@After
	public void cleanDb(){
		Session session = sessionFactory.openSession();
		session.createQuery("DROP TABLE Categories");
	}
}
