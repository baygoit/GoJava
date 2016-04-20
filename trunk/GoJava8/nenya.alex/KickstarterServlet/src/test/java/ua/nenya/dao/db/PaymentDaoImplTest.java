package ua.nenya.dao.db;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
	@ContextConfiguration(locations="classpath*:/aplicationContextTest.xml"),
	  @ContextConfiguration(locations="classpath*:/PaymentTest.hbm.xml")
	})
public class PaymentDaoImplTest {

	private static EmbeddedDatabase db;
	private PaymentDaoImpl paymentDaoImpl = new PaymentDaoImpl();

	@BeforeClass
	public static void setUp() {
		db = new EmbeddedDatabaseBuilder()
	    		.setType(EmbeddedDatabaseType.H2)
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
		long sum = paymentDaoImpl.getPaymentSum(1);
		assertThat(sum, is(100L));
	}
	

	@Test
	public void testWritePaymentInProject() {
		int id = paymentDaoImpl.writePaymentInProject(1, 100);
		assertThat(id, is(4));
	}

}
