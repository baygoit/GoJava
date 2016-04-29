package com.anmertrix.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CategoryTest {

	@Test
	public void setGetNameTest() {
		Category category = new Category();
		category.setName("test2");
		assertThat(category.getName(), is("test2"));
	}
	
	@Test
	public void setGetIdTest() {
		Category category = new Category();
		category.setId(22L);
		assertThat(category.getId(), is(22L));
	}
	
}
