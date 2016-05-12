package com.anmertrix.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
public class PaymentMappingTest {
	
	@PersistenceContext
	private EntityManager em;
	private Payment pt;

	@Before
	public void setUp() {
		Payment payment1 = new Payment();
		payment1.setCardholderName("Payment1");
		
		Payment payment2 = new Payment();
		payment2.setCardholderName("Payment2");
		em.merge(payment1);
		pt = em.merge(payment2);
	}

	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Payment").executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testBasicUsage() {
		List<Payment> payments = em.createQuery("FROM Payment").getResultList();
		assertThat(payments.get(0).getCardholderName(), is("Payment1"));
		assertThat(payments.get(0).getId(), is(1L));
		assertThat(payments.get(1).getCardholderName(), is("Payment2"));
		assertThat(payments.get(1).getId(), is(2L));

		Payment payment = em.find(Payment.class, pt.getId());
		assertThat(payment.getCardholderName(), is("Payment2"));
		assertThat(payment.getId(), is(2L));
	}

}
