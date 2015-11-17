package com.kickstarter.model.test;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import com.kickstarter.model.Project;

public class ProjectTest {
	
	Project p;
	
	

	@Test
	public void test() {
		p = new Project(5, "itproject1", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "", "it");
		assertThat(p.getTitle(), is("itproject1"));
		assertThat(p.getCategoryName(), is("it"));
		assertThat(p.getDiscription(), is("discription1"));
//		assertThat(p.getTitle(), is("itproject1"));
//		assertThat(p.getTitle(), is("itproject1"));
//		assertThat(p.getTitle(), is("itproject1"));
	}

}
