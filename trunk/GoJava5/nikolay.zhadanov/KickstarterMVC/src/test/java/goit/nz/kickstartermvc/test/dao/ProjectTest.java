package goit.nz.kickstartermvc.test.dao;

import static org.junit.Assert.*;
import goit.nz.kickstartermvc.dao.Project;

import org.junit.Test;

public class ProjectTest {

	@Test
	public void whenDescriptionIsEmptyThenReturnThreePoints() {
		Project testProject = new Project("test");
		String expected = "...";
		String actual = testProject.getDescription();
		assertEquals(expected, actual);
	}

	@Test
	public void whenLinkIsEmptyThenReturnFiller() {
		Project testProject = new Project("test");
		String expected = "-/-";
		String actual = testProject.getLink();
		assertEquals(expected, actual);
	}

	@Test
	public void whenAddPledgedAmountThenAmountAdded() {
		Project testProject = new Project("test");
		int expected = 0;
		int actual = testProject.getPledgedAmount();
		assertEquals(expected, actual);

		int testAmount = 10;
		expected = testAmount;
		testProject.addPledgedAmount(testAmount);
		actual = testProject.getPledgedAmount();
		assertEquals(expected, actual);
	}

}
