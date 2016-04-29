package ua.nenya.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aplicationContextTest.xml" })
public class PaymentMapingTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPaymentUsage() {
		int id;
		try (Session session = sessionFactory.openSession()) {
			Payment payment = new Payment();
			payment.setAmount(100);

			id = (int) session.save(payment);
			session.flush();
		}
		try (Session session = sessionFactory.openSession()) {
			List<Payment> payments = session.createQuery("FROM Payment").list();
			assertThat(payments.get(0).getAmount(), is(100));

			Payment payment = session.get(Payment.class, id);
			assertThat(payment.getAmount(), is(100));
		}
	}

}
