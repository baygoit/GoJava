package com.kickstarter.filerun.components.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.kickstarter.filerun.components.FileProjectManager;
import com.kickstarter.filerun.components.FileQuestionSystem;

public class FileQuestionSystemTest {

	static FileProjectManager pm;
	static FileQuestionSystem qs;

	

	@BeforeClass
	public static void setUp() {
		qs = new FileQuestionSystem();
	    pm = new FileProjectManager();
	}

	@Test
	public void addQuestiontTest() {
		FileQuestionSystem qs = new FileQuestionSystem();
		String before = pm.getOne("education", 1).getQuestionSection();
		String newQuestion = "question";
		qs.addNewQuestion(newQuestion, 1, "education");
		assertEquals(before + newQuestion + " | ", pm.getOne("education", 1).getQuestionSection());
	}

}