package ua.nenya.domain;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;

public class ProjectTest {
	
	private Project project = new Project();

	@Before
	public void init() {
		project.setId(1);
		project.setName("New Song");
		project.setDescription("description of new song");
		project.setNeededAmount(100);
		//project.setAvailableAmount(10);
		project.setDaysRemain(100);
		project.setHistory("hystory of new song");
		project.setVideo("video about new song");
	}
	@Test
	public void testGetAll() {
		assertThat(project.getId(), is(1));
		assertThat(project.getName(), is("New Song"));
		assertThat(project.getDescription(), is("description of new song"));
		assertThat(project.getNeededAmount(), is(100));
		//assertThat(project.getAvailableAmount(), is(10));
		assertThat(project.getDaysRemain(), is(100));
		assertThat(project.getHistory(), is("hystory of new song"));
		assertThat(project.getVideo(), is("video about new song"));
	}

}
