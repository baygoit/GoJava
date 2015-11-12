package com.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.kickstarter.beans.Category;

public class CategoryDAOTest {
	
	private CategoryDAO dao = new CategoryDAO();
	private Category category = new Category("cat1");
	
	{
		dao.add(new Category("cat2"));
		dao.add(new Category("cat3"));
		dao.add(category);
	}

	@Test
	public void testGetByName() {
		Category catByName = dao.getByName("cat1");
		assertThat(catByName, is(category));
	}

	@Test
	public void testGetAll() {
		List<Category> list = dao.getAll();
		assertThat(list.isEmpty(), is(false));
	}

	@Test
	public void testGet() {
		Category cat = dao.get(dao.getAll().size()-1);
		assertThat(cat, is(category));
	}

	@Test
	public void testAdd() {
		Category element = new Category("cat4");
		dao.add(element);
		assertThat(dao.getByName("cat4"), is(element));
	}

}
