/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.gojava7.salivon.state;

import java.util.List;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.handlers.HandlerErrorProjectScene;
import ua.com.goit.gojava7.salivon.stores.StoreProjects;
import ua.com.goit.gojava7.salivon.view.Console;

/**
 *
 * @author Оля
 */
public class ProjectState extends State {

    private List<Project> projects = StoreProjects.getProjects();

    public ProjectState() {
        handler = new HandlerErrorProjectScene();
        menu = "Enter 1 - invest in the project.\n"
                + "Enter 2 - ask a question.\n"
                + "Enter 0 - return to above.\n"
                + "Enter 'q' - to exit.\n";

    }

    @Override
    public void outputContentState() {
        int index = State.getIndexProject() - 1;
        System.out.println("Project");
        Project project = projects.get(index);
        System.out.println(project.getTitle());
        System.out.println("  Description: " + project.getDescription());
        System.out.println("  Total " + project.getTotal() + "$");
        System.out.println("  Collected amount " + project.getCollectedAmount());
        System.out.println("  Number of days to end " + project.getNumberOfDaysToEnd());
        System.out.println("  History " + project.getHistoryProject());
        System.out.println("  Link " + project.getLink());
        System.out.println("  FAQ " + project.getFaq() + "\n");
        System.out.println("--------------------------------------------------\n");
        System.out.println(menu);
    }

    @Override
    protected void changeState(Console context, String inData) {
        int inDateToInt = Integer.parseInt(inData);
        if (inDateToInt == 0) {
            context.setCurrentState(context.getCategoryState());
        } else if (inDateToInt==1) {
//            State.setIndexProject(inDateToInt);
//            context.setCurrentState(context.getPaymentState());
        }else{
            
        }
    }

}
