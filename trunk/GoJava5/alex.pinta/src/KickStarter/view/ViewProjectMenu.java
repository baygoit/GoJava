package KickStarter.view;

import KickStarter.controller.CategoryController;
import KickStarter.controller.MainPageController;
import KickStarter.controller.ProjectMenuController;
import KickStarter.model.MainPageModel;
import KickStarter.model.Project;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 14.07.15
 * Time: 14:19
 * @version: 1.0
 */
public class ViewProjectMenu {

    private String stringSeparator;
    private int horizontalSizeOfRenderWorkPlace;
//    private int currentOutputPosition;

    public void render(ProjectMenuController controller) {

        CategoryController categoryController = (CategoryController) controller.getParentController();
        MainPageController mainController = (MainPageController) categoryController.getParentController();
        ViewMainPage parentView = mainController.viewMainPage;
        MainPageModel parentModel = mainController.mainPageModel;

        stringSeparator = parentView.getStringSeparator();
        horizontalSizeOfRenderWorkPlace = parentView.getHorizontalSizeOfRenderWorkPlace();
        horizontalSizeOfRenderWorkPlace = stringSeparator.length() - 2;

        Project elementProject = parentModel.getProject(categoryController.getCategoryModel()).get(categoryController.viewCategory.getCurrentOutputPosition() - 1);

        horizontalSizeOfRenderWorkPlace = parentView.getStringSeparator().length() - 2;

        mainController.deviceOut.replace(controller.deviceOut.getAccumulativeMultiLine(true).toString(), "#projectMenu#");
    }
}
