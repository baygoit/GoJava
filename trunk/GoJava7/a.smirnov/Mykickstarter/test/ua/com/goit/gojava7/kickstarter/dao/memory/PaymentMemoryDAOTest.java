package ua.com.goit.gojava7.kickstarter.dao.memory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Project;

import org.junit.Before;
import org.junit.Test;

public class PaymentMemoryDAOTest {

	private PaymentDaoMemoryImpl paymentMemory;
	private Payment payment;
	private Project project;
	
	
	@Before
	public void setUp() throws Exception {
		paymentMemory = new PaymentDaoMemoryImpl();
		payment = new Payment("Anton", 123456789, 1000);
		project = new Project("Project 1", "XXX", 10_000);
	}

	@Test
	public void testGetSumProjectPayments() {
		int projectID = 0;
		project.setUniqueID(projectID);
		
		payment.setProjectID(projectID);
		paymentMemory.add(payment);
		
		assertThat(paymentMemory.getSumProjectPayments(project), is(1000));
	}

	@Test
	public void testAdd() {
		paymentMemory.add(payment);
		assertThat(paymentMemory.getAll().size(), is(1));
		assertThat(paymentMemory.getAll().get(0).getUserName(), is("Anton"));
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
