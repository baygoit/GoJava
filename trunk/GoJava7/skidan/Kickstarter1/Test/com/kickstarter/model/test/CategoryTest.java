package com.kickstarter.model.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kickstarter.manager.ProjectManager;
import com.kickstarter.model.Category;

public class CategoryTest {


	ProjectManager pm;

	@Test
	public void CategoryFillTest() {
		Category category = new Category("it", 1);
		assertThat(category.getTitle(), is("it"));
		assertThat(category.getProjectList().size(), is(4));
	}

}
