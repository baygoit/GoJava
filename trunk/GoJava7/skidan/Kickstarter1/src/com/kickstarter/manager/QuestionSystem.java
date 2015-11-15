package com.kickstarter.manager;

import com.kickstarter.app.Kickstarter;
import com.kickstarter.model.Project;
import com.kickstarter.util.ConsolePrintView;
import com.kickstarter.util.UserConsoleInputReader;

public class QuestionSystem {
	ConsolePrintView consolePrintView = new ConsolePrintView();
	ProjectManager prm = new ProjectManager();

	public void addQuestion(int projectNumber, int categoryNumber, String categoryTitle) {
		String newQuestion = reciveQuestion();
		Project p = prm.getProject(categoryTitle, projectNumber);
		String questionSection = p.getQuestionSection();
		p.setQuestionSection(questionSection+= newQuestion + "\n");
		consolePrintView.singleCategorysProjectsView(prm.getProject(categoryTitle, projectNumber));
		Kickstarter.projectSelector(categoryNumber, categoryTitle);
	}

	public String reciveQuestion() {
		consolePrintView.InputQuestionInfo();
		return UserConsoleInputReader.readStringInput();
	}
}
