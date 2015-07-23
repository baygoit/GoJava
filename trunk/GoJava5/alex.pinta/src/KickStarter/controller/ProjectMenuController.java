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
    public ViewProjectMenu viewProject;
    public List<Integer> userChoice;
    private EventHandler parentController;

    public ProjectMenuController(ViewProjectMenu viewProject, EventHandler parentController, Output deviceOut) {
        this.deviceOut = deviceOut;
        this.viewProject = viewProject;
        this.parentController = parentController;
        this.categoryModel = ((ProjectController) parentController).categoryModel;
    }

/*    public Project getCategoryModel() {
        return categoryModel;
    }*/

    public EventHandler getParentController() {
        return parentController;
    }

//    public void setCategoryModel(Project categoryModel) {
//        this.categoryModel = categoryModel;
//    }

    @Override
    public void actionPerformed(List<Integer> userChoice) {
        this.userChoice = userChoice;
        parentController.actionPerformed(userChoice);
        viewProject.render(this);
    }

    @Override
    public boolean isHaveToProcessed(List<Integer> userChoice) {
        if (userChoice.size() >= LEVEL_OF_INTERCEPTION_OUTPUT-1 && userChoice.get(LEVEL_OF_INTERCEPTION_OUTPUT - 2) != 0) {
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
