package java.KickStarter.view;

import java.KickStarter.Output;
import java.KickStarter.controller.CategoryController;
import java.KickStarter.controller.MainPageController;
import java.KickStarter.model.MainPageModel;
import java.KickStarter.model.Project;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 14.07.15
 * Time: 14:18
 * @version: 1.0
 */
public class ViewCategory {

    public String stringSeparator;
    public int horizontalSizeOfRenderWorkPlace;
    private int currentOutputPosition;

    public void render(CategoryController controller){

        MainPageController parentController = (MainPageController)controller.getParentController();
        ViewMainPage parentView = parentController.viewMainPage;
        MainPageModel parentModel = parentController.mainPageModel;

            stringSeparator = parentView.getStringSeparator();
            horizontalSizeOfRenderWorkPlace = parentView.getHorizontalSizeOfRenderWorkPlace();
            horizontalSizeOfRenderWorkPlace = stringSeparator.length() - 2;

            currentOutputPosition = 0;
            Project elementProject;
            Output tempDevice = new Output(System.out);
            for (int index = 0; index< parentModel.getProject(controller.getCategoryModel()).size(); index++) {
                tempDevice.writeln(stringSeparator);
                elementProject = parentModel.getProject(controller.getCategoryModel()).get(index);
                tempDevice.writeln("|" + String.format(" %1$-" + horizontalSizeOfRenderWorkPlace + "s",
                        parentView.getTabIndent(controller.LEVEL_OF_INTERCEPTION_OUTPUT) + "*" + (index+1) + " " + elementProject.name) + "|");
                if (controller.isHaveToExpand(index)){
                    currentOutputPosition = index;
                    if (controller.userChoice.size() >= controller.LEVEL_OF_INTERCEPTION_OUTPUT){
                        tempDevice.write("#project#");
                    }
                }
            }
        controller.deviceOut.replace(tempDevice.getAccumulativeMultiLine(true).toString(), "#category#");
    }

    public int getCurrentOutputPosition() {
        return currentOutputPosition;
    }
}
