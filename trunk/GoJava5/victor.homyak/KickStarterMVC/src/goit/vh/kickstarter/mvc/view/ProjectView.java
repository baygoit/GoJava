package goit.vh.kickstarter.mvc.view;

import java.util.Scanner;

import goit.vh.kickstarter.Output;
import goit.vh.kickstarter.mvc.model.ProjectModel;
import goit.vh.kickstarter.model.Project;

/**
 * Created by Viktor on 14.07.2015.
 */
public class ProjectView {
    private String input;
    private Output output;

    public ProjectView(Output output) {
        this.output = output;
    }

    public void renderList(ProjectModel projectModel) {

        Project[] projects = projectModel.getListOfProjectses();
        for (int i = 0; i < projects.length; i++) {
            output.println(String.valueOf(i + 1) + " " + projects[i].getName());
        }
    }

    public void render(ProjectModel projectModel) {
        output.println("You choose option " + projectModel.getProjectName());
    }

    public void readUserInput() {
        output.println("If you want to go back, choose '0'");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        this.input = userInput;
    }

    public String getInput() {
        return this.input;
    }

    public void readInProjectUserInput() {
        output.println("If you want to go back, choose '1'\nIf you want retern to mani menu, choose '0'");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        this.input = userInput;
    }
}