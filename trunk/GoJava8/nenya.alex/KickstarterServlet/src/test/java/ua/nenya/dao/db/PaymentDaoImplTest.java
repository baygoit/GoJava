package ua.nenya.dao.db;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.nenya.dao.PaymentDao;
import ua.nenya.dao.ProjectDao;
import ua.nenya.domain.Payment;
import ua.nenya.domain.Project;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:aplicationContextTest.xml"})
public class PaymentDaoImplTest {

	private static EmbeddedDatabase db;
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private ProjectDao projectDao;

	@BeforeClass
	public static void setUp() {
		db = new EmbeddedDatabaseBuilder()
	    		.setType(EmbeddedDatabaseType.H2)
	    		.addScript("/createPayment.sql")
	    		.addScript("/insertPayment.sql")
	    		.build();
	}
	@AfterClass
	public static void tearDown() {
		db = new EmbeddedDatabaseBuilder()
	    		.setType(EmbeddedDatabaseType.H2)
	    		.addScript("/deletePayment.sql")
	    		.build();
	}
	
	@Test
	public void testGetPaymentSum(){
		long sum = projectDao.getPaymentSum(new Project());
		assertThat(sum, is(100L));
	}
	

	@Test
	public void testWritePaymentInProject() {
		int id = paymentDao.writePaymentInProject(new Payment());
		assertThat(id, is(4));
	}

}
