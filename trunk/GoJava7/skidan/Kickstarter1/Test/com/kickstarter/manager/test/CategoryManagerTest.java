package com.kickstarter.manager.test;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.kickstarter.manager.CategoryManager;
import com.kickstarter.model.Category;

public class CategoryManagerTest {

	@Test
	public void CategoryFillTest() {
		CategoryManager cm = new CategoryManager();
		Category category = new Category("it", 1);
		assertThat(cm.getCategorieByNumber(1).getTitle(), is("it"));
		assertThat(cm.getAllCategories().size(), is(4));
		assertThat(cm.getCategorieByNumber(1).getId(), is(1));
		assertThat(cm.getCategorieByNumber(1).getProjectList().size(), is(4));
	}

}
