package com.kickstarter.manager;

import com.kickstarter.app.KRun;
import com.kickstarter.model.Project;
import com.kickstarter.util.ConsolePrintView;
import com.kickstarter.util.UserConsoleInputReader;

public class QuestionSystem {
	KRun kr = new KRun();
	ConsolePrintView consolePrintView = new ConsolePrintView();
	ProjectManager prm = new ProjectManager();

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
		Project p = prm.getOne(categoryTitle, projectNumber);
		String questionSection = p.getQuestionSection();
		p.setQuestionSection(questionSection += newQuestion + "\n");
	}
}
