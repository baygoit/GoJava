package tyomsky.kickstarter.controller;

import tyomsky.kickstarter.model.Project;
import tyomsky.kickstarter.ui.IO;

import java.util.List;

public class ProjectsMenu extends Menu<Project> {

    private List<Project> projects;

    public ProjectsMenu(List<Project> foundProjects, IO io) {
        super(io);
        this.projects = foundProjects;
    }

    @Override
    public Menu nextMenu(Project selected) {
        return new ProjectMenu(selected, io);
    }

    @Override
    public Project select(int chosenMenuIndex) {
        return chooseProject(projects, chosenMenuIndex);
    }

    @Override
    public void ask() {
        askProjects(projects);
    }

    private Project chooseProject(List<Project> foundProjects, int chosenMenuIndex) {
        if (projectIndexIsInvalid(chosenMenuIndex, foundProjects)) {
            io.println("You have chosen wrong menu index " + chosenMenuIndex);
            return null; // or nil
        }
        Project project = foundProjects.get(chosenMenuIndex - 1);
        io.println("You have chosen: " + project.getName());
        return project;
    }

    private boolean projectIndexIsInvalid(int chosenMenuIndex, List<Project> projectsList) {
        return chosenMenuIndex <= 0 || chosenMenuIndex > projectsList.size();
    }

    private void askProjects(List<Project> foundProjects) {
        showProjects(foundProjects);
        io.println("Select item (0 for exit)");

    }

    private void showProjects(List<Project> foundProjects) {
        if (foundProjects.size() == 0) {
            io.println("nothing to do here.");
        }
        for (int i = 0; i < foundProjects.size(); i++) {
            int menuIndex = i + 1;
            Project project = foundProjects.get(i);
            io.println(menuIndex + ": " + project.getShortPresentation());
            io.println("------------------------------------------------------");
        }
    }

}
