package KickStarter.controller;

import KickStarter.Output;
import KickStarter.model.Project;
import KickStarter.view.ViewProjectMenu;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 21.07.15
 * Time: 20:50
 * @version: 1.0
 */
public class ProjectMenuController implements EventHandler {
    public final int LEVEL_OF_INTERCEPTION_OUTPUT = 4;
    public Output deviceOut;
    public Project categoryModel;
    public ViewProjectMenu viewProjectMenu;
    public List<Integer> userChoice;
    private EventHandler parentController;

    public ProjectMenuController(ViewProjectMenu viewProject, EventHandler parentController, Output deviceOut) {
        this.deviceOut = deviceOut;
        this.viewProjectMenu = viewProject;
        this.parentController = parentController;
        this.categoryModel = ((ProjectController) parentController).categoryModel;
    }

    public EventHandler getParentController() {
        return parentController;
    }

    @Override
    public void actionPerformed(List<Integer> userChoice) {
        this.userChoice = userChoice;
        categoryModel = ((ProjectController)parentController).categoryModel;
        parentController.actionPerformed(userChoice);
        viewProjectMenu.render(this);
    }

    @Override
    public boolean isHaveToProcessed(List<Integer> userChoice) {
        if (userChoice.size() == LEVEL_OF_INTERCEPTION_OUTPUT-1 && userChoice.get(LEVEL_OF_INTERCEPTION_OUTPUT - 2) != 0) {
            this.userChoice = userChoice;
            return true;
        }
        return false;
    }

    @Override
    public boolean isHaveToExpand(int verifiableID) {
        return true;
    }
}
