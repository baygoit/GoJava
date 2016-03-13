package ua.nenya.pages;

import ua.nenya.project.Project;
import ua.nenya.util.IO;

public class AskingQuestionPage {

	public boolean askQuestion(Project project, IO io) {
		boolean b = false;
		io.write("Do you want to ask a question? (y/n): ");
		io.writeln("");
		if (io.readConsole().equals("y")) {
			b = true;
			io.write("Enter your question: ");
			String question = io.readConsole();
			project.setQuestionAnswer(question);
		}
		return b;
	}
	
}
