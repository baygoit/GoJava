package ua.com.goit.gojava7.kickstarter.dao.memory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Project;

public class PaymentMemoryDAOTest {

	private PaymentDaoMemoryImpl paymentMemory = new PaymentDaoMemoryImpl();
	private Payment payment = new Payment();
	private Project project = new Project();
	private int projectID = 1;
	private int donatingSum = 1_000_000;
	
	@Before
	public void setUp() throws Exception {
		payment.setProjectID(projectID);
		payment.setDonatingSum(donatingSum);
		project.setUniqueID(projectID);
	}

	@Test
	public void testPaymentMemoryDAO() {
		assertThat(paymentMemory.getSize(), is(0));
	}
	
	@Test
	public void testGetSumProjectPayments() {
		paymentMemory.add(payment);	
		assertThat(paymentMemory.getSumProjectPayments(project), is(donatingSum));
	}

	@Test
	public void testAdd() {
		paymentMemory.add(payment);
		assertThat(paymentMemory.getAll().size(), is(1));
	}

	@Test
	public void testRemove() {
		paymentMemory.add(payment);
		assertThat(paymentMemory.getAll().size(), is(1));
		
		paymentMemory.remove(payment);
		assertThat(paymentMemory.getAll().size(), is(0));
	}

	@Test
	public void testGetAll() {
		assertThat(paymentMemory.getAll().size(), is(0));
	}

	@Test
	public void testGetSize() {
		assertThat(paymentMemory.getSize(), is(0));
	}

}
