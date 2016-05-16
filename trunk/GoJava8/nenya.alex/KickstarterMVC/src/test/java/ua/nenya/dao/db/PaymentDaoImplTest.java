package ua.nenya.dao.db;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.dao.PaymentDao;
import ua.nenya.domain.Payment;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:aplicationContextTest.xml"})
public class PaymentDaoImplTest {

	@PersistenceContext
	private EntityManager em;
	@Autowired
	private PaymentDao paymentDao;
	private Payment payment = new Payment();

	@Before
	public void setUp() {
		payment.setAmount(100);
	}

	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Payment").executeUpdate();
	}
	
	@Test
	public void testWritePaymentInProject() {
		Payment newPayment = paymentDao.writePaymentInProject(payment);
		Payment paymentTest = em.find(Payment.class, newPayment.getId());
		assertThat(paymentTest.getAmount(), is(payment.getAmount()));
	}

}
