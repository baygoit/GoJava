package goit.vh.kickstarter.mvc.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import goit.vh.kickstarter.Input;
import goit.vh.kickstarter.Output;
import goit.vh.kickstarter.mvc.model.ProjectModel;

/**
 * Created by Viktor on 14.07.2015.
 */
public class ProjectView {

    private String input;
    private Output output;

    public ProjectView(Output output) {
        this.output = output;
    }

    public void renderList(ArrayList<ProjectModel> projects) {

        for (int i = 0; i < projects.size(); i++) {
            output.println(String.valueOf(i + 1) + " " + projects.get(i).getProjectName() + " " + projects.get(i).getShortDescription() +
                    "\n Sum to raise: " + projects.get(i).getSumToRaise() + "; Already collected: " + projects.get(i).getCurrentSum()
                    + "; Days to end raising money: " +
                    getDateDiff(new Date(), projects.get(i).getEndDate(), TimeUnit.DAYS));

        }
        readUserInput();
        setInput(new Input().getInput());

    }

    public void render(ProjectModel projectModel) {
//        output.println("You choose option " + projectModel.getProjectName());
        output.println(projectModel.getShortDescription() +
                "\n Sum to raise: " + projectModel.getSumToRaise() + "; Already collected: "
                + projectModel.getCurrentSum() + "; Days to end raising money: " +
                getDateDiff(new Date(), projectModel.getEndDate(), TimeUnit.DAYS) + "\n Project history: " +
                projectModel.getProjectHistory() + "\n Demo video: " + projectModel.getDemoURL() + ";\nFAQ: " + projectModel.getfAQ());
    }

    public void readUserInput() {
        output.println("If you want to go back, choose '0'");
    }


    public void readInProjectUserInput() {
        output.println("If you want to go back, choose '1'\nIf you want retern to mani menu, choose '0'");
        setInput(new Input().getInput());
    }

    /**
     * Get a diff between two dates
     *
     * @param date1    the oldest date
     * @param date2    the newest date
     * @param timeUnit the unit in which you want the diff
     * @return the diff value, in the provided unit
     */
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
    public void setInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

}