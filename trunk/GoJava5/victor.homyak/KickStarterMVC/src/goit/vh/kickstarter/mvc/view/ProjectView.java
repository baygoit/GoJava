package goit.vh.kickstarter.mvc.view;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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

    public void renderList(Project[] projects) {


        for (int i = 0; i < projects.length; i++) {
            output.println(String.valueOf(i + 1) + " " + projects[i].getName() + " " + projects[i].getShortDescription() +
                    " " + projects[i].getSumToRaise() + " " + projects[i].getCurrentSum() + " " +
                    getDateDiff(new Date(),projects[i].getEndDate(), TimeUnit.DAYS));
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

    /**
     * Get a diff between two dates
     * @param date1 the oldest date
     * @param date2 the newest date
     * @param timeUnit the unit in which you want the diff
     * @return the diff value, in the provided unit
     */
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
}