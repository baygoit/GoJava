package ua.nenya.alex.pages;

import ua.nenya.alex.project.Project;
import ua.nenya.alex.util.IO;

public class AskQuestionPage {

	public boolean askQuestion(Project project, IO io) {
		boolean b = false;
		io.write("Do you want to ask a question? (y/n): ");
		io.writeEmpty();
		if (io.readConsole().equals("y")) {
			b = true;
			io.write("Enter your question: ");
			String question = io.readConsole();
			project.setQuestionAnswer(question);
		}
		return b;
	}
	
}
