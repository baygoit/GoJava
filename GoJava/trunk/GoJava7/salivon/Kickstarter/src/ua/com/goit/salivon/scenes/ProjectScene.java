/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.salivon.scenes;

import ua.com.goit.salivon.beans.Project;
import ua.com.goit.salivon.stores.StoreProjects;

/**
 *
 * @author Оля
 */
public class ProjectScene extends ViewScene {

    private StoreProjects projects;
    private int data;

    public ProjectScene(StoreProjects projects, int data) {
        this.projects = projects;
        this.data = data;
        menu = "Enter 1 - invest in the project.\n"
                + "Enter 2 - ask a question.\n"
                + "Enter 0 - return to above.\n"
                + "Enter 'q' - to exit.\n";
        createScene();
    }

    @Override
    protected void createScene() {
        int index = data - 1;
        textScene.append("Project\n");
        Project project = projects.getProject(index);
        textScene.append(project.getTitle() + "\n");
        textScene.append("  Description: " + project.getDescription() + "\n");
        textScene.append("  Total " + project.getTotal() + "$\n");
        textScene.append("  Collected amount " + project.getCollectedAmount() + "\n");
        textScene.append("  Number of days to end " + project.getNumberOfDaysToEnd() + "\n");
        textScene.append("  History " + project.getHistoryProject() + "\n");
        textScene.append("  Link " + project.getLink() + "\n");
        textScene.append("  FAQ " + project.getFaq() + "\n\n");
        textScene.append("--------------------------------------------------\n");
        textScene.append(menu);
    }

}
