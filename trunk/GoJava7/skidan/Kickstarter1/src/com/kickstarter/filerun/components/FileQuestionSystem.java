package com.kickstarter.filerun.components;


import java.util.LinkedHashMap;
import java.util.Map;

import com.kickstarter.model.Project;
import com.kickstarter.util.ConsolePrintView;
import com.kickstarter.util.UserConsoleInputReader;

public class FileQuestionSystem {
	FilePaymentSystem fpm = new FilePaymentSystem();
	KRunFromFile kr = new KRunFromFile();
	ConsolePrintView consolePrintView = new ConsolePrintView();
	FileProjectManager prm = new FileProjectManager();

	public void provideNewQuestion(int projectNumber, int categoryNumber, String categoryTitle) {
		String newQuestion = reciveQuestion();
		addNewQuestion(newQuestion, projectNumber, categoryTitle);
		consolePrintView.singleCategorysProjectsView(prm.getOne(categoryTitle, projectNumber));
		kr.projectSelector(categoryNumber, categoryTitle);
	}

	public String reciveQuestion() {
		consolePrintView.InputQuestionInfo();
		return UserConsoleInputReader.readStringInput();
	}

	public void addNewQuestion(String newQuestion, int projectNumber, String categoryTitle) {
		LinkedHashMap<Integer, Project> allProjects = prm.getWholeProjectMap();
		Project p = prm.getOne(categoryTitle, projectNumber);
		String questionSection = p.getQuestionSection();
		p.setQuestionSection(questionSection += newQuestion + " | ");
		allProjects.put(projectNumber, p);
		fpm.writeToFile(allProjects);
	}
	
	
	
}
