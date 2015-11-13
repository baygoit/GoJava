package ua.com.goit.gojava7.kickstarter.beans;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Pledge;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.beans.User;

public class PledgeTest {
	
	User user = new User("testUser");
	Project project = Project.newBuilder().setName("testProj").build();
	Payment payment = new Payment(user, 123, 456, new Date());
	Pledge testObject = new Pledge(project, payment);

	@Test
	public void testGetPledgeSum() {
		assertThat(testObject.getPledgeSum(), is(payment.getSum()));
	}

	@Test
	public void testGetUser() {
		assertThat(testObject.getUser(), is(user));
	}

	@Test
	public void testSetReward() {
		Reward reward = new Reward(project, "test description", 100L);
		testObject.setReward(reward);
		assertThat(testObject.getReward(), is(reward));
	}

	@Test
	public void testSetProject() {
		assertThat(testObject.getProject(), is(project));
		Project anotherProject = Project.newBuilder().setName("another testProj").build();
		testObject.setProject(anotherProject);
		assertThat(testObject.getProject(), is(anotherProject));
	}

	@Test
	public void testGetDate() {
		assertThat(testObject.getDate(), is(payment.getDate()));
	}

}
