package nikfisher.kickstarter.menu;

import nikfisher.kickstarter.model.Project;
import nikfisher.kickstarter.streams.ConsoleInterfaceIO;

import java.util.List;

class ProjectsMenu {

    final private ConsoleInterfaceIO IO;

    public ProjectsMenu(ConsoleInterfaceIO io) {
        this.IO = io;
    }

    public void projectsMenu(List<Project> foundProjects) {


        while (true) {

            ascProjects(foundProjects);

            int menuIndex = IO.consoleScanInt();

            if (menuIndex == 0) {
                break;
            }
//
            if (menuIndex <= 0 || foundProjects.size() < menuIndex) {
                IO.println("Not true index: " + menuIndex);
                continue;
            }
            Project project = foundProjects.get(menuIndex - 1);

            chooseProject(project);
            printProjectDetail(project);

            ProjectMenu projectMenu = new ProjectMenu(IO);
            projectMenu.projectMenuRun(project);
        }
    }

    private void ascProjects(List<Project> foundProjects) {

        if (foundProjects.size() == 0) {
            IO.println("Projects in this category do not have to exit, enter 0");
        } else {
            int from = 1;
            int to = foundProjects.size();
            IO.println("Select project: [" + from + "..." + to + " or 0 for exit to the projects list");
        }
    }

    private void printProjectDetail(Project project) {

        IO.println("Project detail:");
        printProject(project);

        String history = project.getHistory();
        if (history != null) {
            IO.println(history);
        }

        String video = project.getVideo();
        if (video != null) {
            IO.println(video);
        }

        String question = project.getQuestion();
        if (question != null) {
            IO.println(question);
        }

        String answer = project.getAnswer();
        if (answer != null) {
            IO.println(answer);
        }

        IO.println("---------------------------------------");
    }

    private void chooseProject(Project project) {

        IO.println("You selected project: " + project.getName());
    }

    //TODO method duplicated in CategoryMenu Class, need will think about this
    private void printProject(Project project) {

        IO.println("Project name: " + project.getName());
        IO.println("Description: " + project.getDescription());
        IO.println("Need collected: " + project.getAmount() + "$");
        IO.println("Already collected: " + project.getExist() + "$");
        IO.println("Days remaining: " + project.getDays());
        IO.println("---------------------------------------");
        String SPACE = " ";
        IO.println(SPACE);
    }

}
