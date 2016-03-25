package ua.nenya.pages;

import java.util.Arrays;
import java.util.List;

import ua.nenya.project.Category;
import ua.nenya.project.GettingNameInterface;
import ua.nenya.project.Project;
import ua.nenya.project.Question;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;
import ua.nenya.main.DaoInitilizer;

public class ProjectPage {
	private DaoInitilizer initilizer;
	private IO io;
	private ListUtilits listUtil;

	private enum InvestitionOrAskingEnum implements GettingNameInterface {
		INVEST_IN_PROJECT("Invest in project"), ASK_A_QUESTION("Ask a question");

		private String name;

		InvestitionOrAskingEnum(String name) {
			this.name = name;
		}

		@Override
		public String getName() {
			return name;
		}
	}

	public void showAllProjectsOfCategory(DaoInitilizer initilizer, IO io, Category category, ListUtilits listUtil) {
		this.initilizer = initilizer;
		this.io = io;
		this.listUtil = listUtil;
		List<Project> projects = initilizer.getCategoryDao().initProjects(category);
		for (int i = 0; i < projects.size(); i++) {
			printMainInformation(projects.get(i));
			io.writeln("------------------------------------------");
		}
		showChosenProject(projects);
	}

	private void showChosenProject(List<Project> projects) {
		int index;
		while ((index = listUtil.choseIndexFromList(projects, io)) != 0) {
			Project chosenProject = projects.get(index - 1);
			io.writeln("You've chosen " + chosenProject.getName());
			printAllInformation(chosenProject);

			List<InvestitionOrAskingEnum> list = Arrays.asList(InvestitionOrAskingEnum.values());
			int innerIndex;
			while ((innerIndex = listUtil.choseIndexFromList(list, io)) != 0) {
				InvestitionOrAskingEnum item = list.get(innerIndex - 1);
				if (item == InvestitionOrAskingEnum.INVEST_IN_PROJECT) {
					new InvestitionProjectPage().investInProject(initilizer, chosenProject, io, listUtil);
				}
				if (item == InvestitionOrAskingEnum.ASK_A_QUESTION) {
					askQuestion(chosenProject);
				}
			}
		}
	}

	private void askQuestion(Project project) {
		io.write("Do you want to ask a question? (y/n): ");
		io.writeln("");
		if (io.readConsole().equals("y")) {
			io.write("Enter your question: ");
			Question question = new Question();
			question.setName(io.readConsole());
			initilizer.getCategoryDao().writeQuestionInProject(project, question);
		}
	}
	
	private void printMainInformation(Project project) {
		io.writeln("Progect name:		" + project.getName());
		io.writeln("Description:		" + project.getDescription());
		io.writeln("Needed amount:		" + project.getNeededAmount());
		io.writeln("Available amount:	" + project.getAvailableAmount());
		io.writeln("Remaining days:		" + project.getDaysRemain());
	}

	private void printAllInformation(Project project) {
		printMainInformation(project);
		io.writeln("History:		" + project.getHistory());
		io.writeln("Video:		" + project.getVideo());
		io.writeln("Q&A:		" );
		showQuestions(project);
		io.writeln("------------------------------------------");
	}

	private void showQuestions(Project project) {
		List<Question> questions = initilizer.getCategoryDao().initQuestions(project);
		if (questions.size() != 0) {
			for (int i = 0; i < questions.size(); i++) {
				io.writeln(i + 1 + ".	" + questions.get(i).getName());
			}
		} else {
			io.writeln("No questions!");
		}
	}

}
