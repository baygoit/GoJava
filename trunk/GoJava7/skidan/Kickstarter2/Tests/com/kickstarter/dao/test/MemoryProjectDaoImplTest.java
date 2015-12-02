package com.kickstarter.dao.test;

import static org.junit.Assert.*;



import org.junit.Test;

import com.kickstarter.dao.impl.MemoryProjectDaoImpl;
import com.kickstarter.memory.storage.ProjectDB;



public class MemoryProjectDaoImplTest {
	
	MemoryProjectDaoImpl mpd;
	
	@Test
	public void getAllTest() {
		mpd = new MemoryProjectDaoImpl();
		assertEquals(mpd.getAll("it").get(0).getCategoryName(), ("it"));
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
	
//	@Test
//	public void updateTest() {
//		mpd = new MemoryProjectDaoImpl();
//		List<Project> allProjects = ProjectDB.allProjectsList;
//		int i = 0;
//		for (Project project : allProjects) {
//			if (project.getCategoryName().equals(p.getCategoryName())) {
//				allProjects.remove(i);
//				allProjects.add(i, p);
//				break;
//			} else {
//				i++;
//				continue;
//			}
//	
	
}
