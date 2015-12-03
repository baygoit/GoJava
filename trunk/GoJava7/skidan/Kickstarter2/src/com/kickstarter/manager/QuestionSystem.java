package com.kickstarter.manager;

import com.kickstarter.dao.QuestionDao;
import com.kickstarter.model.Project;
import com.kickstarter.util.ConsolePrintView;
import com.kickstarter.util.UserConsoleInputReader;

public class QuestionSystem {
	QuestionDao questionDao = new QuestionDao();
	ConsolePrintView consolePrintView = new ConsolePrintView();

	public void provideNewQuestion(Project p) {
		String newQuestion = reciveQuestion();
		questionDao.add(newQuestion, p);

	}

	public String reciveQuestion() {
		consolePrintView.InputQuestionInfo();
		return UserConsoleInputReader.readStringInput();
	}

}
