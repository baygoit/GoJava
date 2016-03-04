package ua.nenya.alex.pages;

import java.util.Arrays;
import java.util.List;

import ua.nenya.alex.enums.InvestAndAskEnum;
import ua.nenya.alex.project.Category;
import ua.nenya.alex.project.Project;
import ua.nenya.alex.util.IO;
import ua.nenya.alex.util.ListUtilits;

public class ProjectPage {

	public boolean showTotalProject(Project project, IO io, Category category, ListUtilits listUtil) {
		boolean b = false;
		List<Project> listOfProjects = project.getProjects(category);
		for (int i = 0; i < listOfProjects.size(); i++) {
			printMainInformation(listOfProjects.get(i), io);
			io.writeln("------------------------------------------");
		}

		int index;
		while ((index = listUtil.choseIndexFromList(listOfProjects, io)) != 0) {
			b = true;
			Project chosenProject = listOfProjects.get(index-1);
			io.writeln("You've chosen "+chosenProject.getName());
			printAllInformation(chosenProject, io);

			List<InvestAndAskEnum> list = Arrays.asList(InvestAndAskEnum.values());

			int innerIndex;

			while ((innerIndex = listUtil.choseIndexFromList(list, io)) != 0) {
				InvestAndAskEnum item = list.get(innerIndex-1);
				if (item == InvestAndAskEnum.INVEST_IN_PROJECT) {
					new InvestProjectPage().investInProject(chosenProject, io, listUtil);
					b = true;
				}
				if (item == InvestAndAskEnum.ASK_A_QUESTION) {
					new AskQuestionPage().askQuestion(chosenProject, io);
					b = true;
				}
			}
		}
		return b;
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
