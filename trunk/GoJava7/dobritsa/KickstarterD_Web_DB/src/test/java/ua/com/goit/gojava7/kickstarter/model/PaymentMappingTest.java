package ua.com.goit.gojava7.kickstarter.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/H2/H2ApplicationContext*.xml")
@Transactional
public class PaymentMappingTest {

	@PersistenceContext
	private EntityManager em;

	@Test
	public void testBasicUsage() {

		Category category1 = new Category();
		category1.setName("TestCategory 1");

		Project project1 = new Project();
		project1.setName("TestName1");
		project1.setDescription("TestDescription1");
		project1.setGoal(100L);
		project1.setDaysToGo(1L);
		project1.setHistory("TestHistory1");
		project1.setLink("TestLink1");
		project1.setCategory(category1);

		Payment payment1 = new Payment();
		payment1.setUser("Nike1");
		payment1.setCard("1111222233334444");
		payment1.setAmount(100L);
		payment1.setProject(project1);

		Payment payment2 = new Payment();
		payment2.setUser("Nike2");
		payment2.setCard("1111222233332222");
		payment2.setAmount(200L);
		payment2.setProject(project1);

		em.persist(payment1);
		em.persist(payment2);
		Long paymendId1 = payment1.getPaymentId();
		Long projectId1 = project1.getProjectId();
		Long categoryId1 = category1.getCategoryId();

		
		System.out.println("\n-----Get Payment by id = 1-----");
		Payment payment = em.find(Payment.class, paymendId1);
		System.out.println(payment);
		
		System.out.println("\n-----Get Project by id = 1-----");
		Project project = em.find(Project.class, projectId1);
		System.out.println("Project: " + project);
		
		System.out.println("\n-----Get Category by id = 1-----");
		Category category = em.find(Category.class, categoryId1);
		System.out.println("Category: " + category);		

//		System.out.println("\n-----Get list of payments-----");
//		List<Payment> payments = (List<Payment>) session.createQuery("from Payment q").list();
//		for (Payment resultPayment : payments) {
//			System.out.println(resultPayment);
//		}
	}
}
