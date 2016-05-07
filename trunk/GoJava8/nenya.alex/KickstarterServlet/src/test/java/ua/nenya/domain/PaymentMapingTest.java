package ua.nenya.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aplicationContextTest.xml" })
public class PaymentMapingTest {

	@PersistenceContext
	private EntityManager em;
	private Payment p;
	
	@Before
	public void setUp() {
		Payment payment = new Payment();
		payment.setAmount(100);
		p = em.merge(payment);
	}
	
	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Payment").executeUpdate();
	}

	@Test
	public void testPaymentUsage() {
		Payment paymentTest1 = (Payment) em.createQuery("FROM Payment").getSingleResult();
		assertThat(paymentTest1.getAmount(), is(100));

		Payment paymentTest = em.find(Payment.class, p.getId());
		assertThat(paymentTest.getAmount(), is(100));
	}

}
