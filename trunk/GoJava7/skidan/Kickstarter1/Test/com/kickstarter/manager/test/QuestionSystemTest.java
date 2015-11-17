package com.kickstarter.manager.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;

import org.mockito.Mock;


import com.kickstarter.manager.ProjectManager;
import com.kickstarter.manager.QuestionSystem;


public class QuestionSystemTest {

	static ProjectManager pm;
	static QuestionSystem qs;

	

	@BeforeClass
	public static void setUp() {
		qs = new QuestionSystem();
	    pm = new ProjectManager();
	}

	@Test
	public void addQuestiontTest() {
		qs.addNewQuestion("q", 2, "sport");
		assertEquals("q"+ "\n", pm.getOne("sport", 2).getQuestionSection());
	}

}
