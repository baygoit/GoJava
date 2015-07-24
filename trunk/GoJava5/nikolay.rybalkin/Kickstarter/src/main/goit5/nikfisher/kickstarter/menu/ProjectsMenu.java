package goit5.nikfisher.kickstarter.menu;

import goit5.nikfisher.kickstarter.model.Model.Project;
import goit5.nikfisher.kickstarter.streams.InputOutputConsole;
import goit5.nikfisher.kickstarter.streams.InputOutputConsoleInterface;

public class ProjectsMenu {

	private InputOutputConsoleInterface io;

    public ProjectsMenu(InputOutputConsoleInterface io) {
        this.io = io;
    }

	public void projectsMenu(Project[] foundProjects) {

		while (true) {

            ascProjects(foundProjects);

            int menuIndex = io.consoleScanInt();

            if (menuIndex == 0){
                break;
            }

            if (menuIndex <= 0 || foundProjects.length <  menuIndex){
				io.println("Not true index: " + menuIndex);
                continue;
            }
            Project project = foundProjects[menuIndex - 1];

            chooseProject(project);
            printProjectDetail(project);

            ProjectMenu projectMenu = new ProjectMenu(new InputOutputConsole());
			projectMenu.projectMenuRun(project);
		}
	}

    private void ascProjects(Project[] foundProjects) {

		if (foundProjects.length == 0 ){
			io.println("InMemoryProjects in this category do not have to exit, enter 0");
		}else {
			int from = 1;
			int to = foundProjects.length;
			io.println("Select project: [" + from + "..." +  to  + " or 0 for exit to the projects list");
		}
	}

    private void printProjectDetail(Project project) {

		io.println("Project detail:");
		printProject(project);

		String history = project.getHistory();
		if (history != null){
			io.println(history);
		}

		String video = project.getVideo();
		if (video != null){
			io.println(video);
		}

		String question = project.getQuestion();
		if (question != null){
			io.println(question);
		}

		String answer = project.getAnsver();
		if (answer != null){
			io.println(answer);
		}

		io.println("---------------------------------------");
	}

	private void chooseProject(Project project) {

		io.println("You selected project: " + project.getName());
	}

    //TODO method duplicated in CategoryMenu Class, need will think about this
	private void printProject(Project project) {

        io.println("Project name: " + project.getName());
        io.println("Description: " + project.getDescription());
        io.println("Need collected: " + project.getAmount() + "$");
        io.println("Already collected: " + project.getExist() + "$");
        io.println("Days remaining: " + project.getDays());
        io.println("---------------------------------------");
		String SPACE = " ";
		io.println(SPACE);
    }

}
