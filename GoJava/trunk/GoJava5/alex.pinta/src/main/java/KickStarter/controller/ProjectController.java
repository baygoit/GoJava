package KickStarter.controller;

import KickStarter.Output;
import KickStarter.model.Project;
import KickStarter.view.ViewProject;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 12.07.15
 * Time: 21:28
 * @version: 1.0
 */
public class ProjectController implements EventHandler{
    public final int LEVEL_OF_INTERCEPTION_OUTPUT = 3;
    public Output deviceOut;
    public Project categoryModel;
    public ViewProject viewProject;
    public List<Integer> userChoice;
    private EventHandler parentController;

    public ProjectController(ViewProject viewProject, EventHandler parentController, Output deviceOut) {
        this.deviceOut = deviceOut;
        this.viewProject = viewProject;
        this.parentController = parentController;
    }

/*    public Project getCategoryModel() {
        return categoryModel;
    }*/

    public EventHandler getParentController() {
        return parentController;
    }

    public void setCategoryModel(Project categoryModel) {
        this.categoryModel = categoryModel;
    }

    @Override
    public void actionPerformed(List<Integer> userChoice) {
        this.userChoice = userChoice;
        MainPageController mainController = (MainPageController)((CategoryController) parentController).getParentController();
        parentController.actionPerformed(userChoice);
        setCategoryModel(mainController.mainPageModel.getProject(((CategoryController) parentController).categoryModel).get(
                        ((CategoryController) parentController).viewCategory.getCurrentOutputPosition() - 1));
        viewProject.render(this);
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
        if (userChoice.size() >= LEVEL_OF_INTERCEPTION_OUTPUT && userChoice.get(LEVEL_OF_INTERCEPTION_OUTPUT-1) == verifiableID){
            return true;
        }
        return false;
    }
}
