package com.kickstarter.dao.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import com.kickstarter.dao.impl.MemoryCategoryDaoImpl;
import com.kickstarter.memory.storage.CategoryDB;
import com.kickstarter.model.Category;

public class CategoryDaoTest {

	MemoryCategoryDaoImpl cd;
	CategoryDB cdb;

	@Before
	public void setUp() {
		cdb = new CategoryDB();
		cd = new MemoryCategoryDaoImpl();
	}

	@Test
	public void getAllTest() {
		List<Category> list = cd.getAll();
		assertEquals(list.get(0).getId(), (cdb.categorylist.get(0).getId()));
		assertEquals(list.get(list.size() - 1).getTitle(),
				(cdb.categorylist.get(cdb.categorylist.size() - 1).getTitle()));

	}
	@Test
	public void getOneCategoryByIdFromMemoryStorageTest() {
		Category c = cd.getByNumber(1);
		assertEquals(c.getId(),cdb.categorylist.get(c.getId() -1).getId());
		assertEquals(c.getTitle(),cdb.categorylist.get(c.getId() -1).getTitle());

	}

}
