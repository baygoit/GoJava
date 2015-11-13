package ua.com.goit.gojava7.kickstarter.beans;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.Reward;

public class RewardTest {

	Project project = new Project();
	Reward testObject = new Reward(project, "testMessage", 200L);
	
	@Test
	public void testSetProject() {
		Project project = Project.newBuilder().setName("testProj").build();
		testObject.setProject(project);
		assertThat(testObject.getProject(), is(project));
	}

	@Test
	public void testSetPledgeSum() {
		long sum = 500L;
		testObject.setPledgeSum(sum);
		assertThat(testObject.getPledgeSum(), is(sum));
	}

	@Test
	public void testSetDescription() {
		String desc = "testDescription";
		testObject.setDescription(desc);
		assertThat(testObject.getDescription(), is(desc));
	}

}
