package com.kickstarter.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.kickstarter.dao.impl.MemoryProjectDaoImpl;
import com.kickstarter.memory.storage.ProjectDB;
import com.kickstarter.model.Category;
import com.kickstarter.model.Project;

public class MemoryProjectDaoImplTest {
	
	MemoryProjectDaoImpl mpd;
	
	@Test
	public void getAllTest() {
		mpd = new MemoryProjectDaoImpl();
		assertEquals(mpd.getAll(new Category("it",1)).get(0).getCategoryName(), ("it"));
	}
	
	@Test
	public void  getOneTst() {
		mpd = new MemoryProjectDaoImpl();
		assertEquals(mpd.getOne(5).getId(), (5));
		
	}
	@Test
	public void getAllListTest() {
		mpd = new MemoryProjectDaoImpl();
		assertEquals(mpd.getAllList(),ProjectDB.allProjectsList);
	}
}
