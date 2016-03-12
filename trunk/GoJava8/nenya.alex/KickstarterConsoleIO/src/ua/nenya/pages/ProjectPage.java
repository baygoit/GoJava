package ua.nenya.pages;

import java.util.Arrays;
import java.util.List;

import ua.nenya.enums.InvestitionOrAskingEnum;
import ua.nenya.project.Category;
import ua.nenya.project.Project;
import ua.nenya.project.Projects;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;

public class ProjectPage {

	public void showTotalProject(Projects projects, IO io, Category category, ListUtilits listUtil) {
		List<Project> listOfProjects = projects.getProjects(category);
		for (int i = 0; i < listOfProjects.size(); i++) {
			printMainInformation(listOfProjects.get(i), io);
			io.writeln("------------------------------------------");
		}

		int index;
		while ((index = listUtil.choseIndexFromList(listOfProjects, io)) != 0) {
			Project chosenProject = listOfProjects.get(index-1);
			io.writeln("You've chosen "+chosenProject.getName());
			printAllInformation(chosenProject, io);

			List<InvestitionOrAskingEnum> list = Arrays.asList(InvestitionOrAskingEnum.values());

			int innerIndex;

			while ((innerIndex = listUtil.choseIndexFromList(list, io)) != 0) {
				InvestitionOrAskingEnum item = list.get(innerIndex-1);
				if (item == InvestitionOrAskingEnum.INVEST_IN_PROJECT) {
					new InvestitionProjectPage().investInProject(chosenProject, io, listUtil);
				}
				if (item == InvestitionOrAskingEnum.ASK_A_QUESTION) {
					new AskingQuestionPage().askQuestion(chosenProject, io);
				}
			}
		}
	}
	
	private void printMainInformation(Project project, IO io) {
		io.writeln("Progect name:		" + project.getName());
		io.writeln("Description:		" + project.getDescription());
		io.writeln("Needed amount:		" + project.getAllAmount());
		io.writeln("Available amount:	" + project.getAvailableAmount());
		io.writeln("Remaining days:		" + project.getDaysRemain());
	}
	
	private void printAllInformation(Project project, IO io) {
		printMainInformation(project, io);
		io.writeln("History:		" + project.getHistory());
		io.writeln("Video:		" + project.getVideo());
		io.writeln("Q&A:		" + project.getQuestionAnswer());
		io.writeln("------------------------------------------");
	}
}
