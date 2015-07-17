package Lessons1.KickStarter.view;

import Lessons1.KickStarter.controller.CategoryController;
import Lessons1.KickStarter.controller.EventHandler;
import Lessons1.KickStarter.controller.MainPageController;
import Lessons1.KickStarter.model.MainPageModel;
import Lessons1.KickStarter.model.Project;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 14.07.15
 * Time: 14:18
 * @version: 1.0
 */
public class ViewCategory {

    private String stringSeparator;
    private int horizontalSizeOfRenderWorkPlace;
    private int currentOutputPosition;

    public void render(CategoryController controller){

        MainPageController parentController = (MainPageController)controller.getParentController();
        ViewMainPage parentView = parentController.viewMainPage;
        MainPageModel parentModel = parentController.mainPageModel;

        //if (Integer.parseInt(controller.userChoice[controller.LEVEL_OF_INTERCEPTION_OUTPUT-2]) == parentView.getCurrentOutputPosition()-1){
            stringSeparator = parentView.getStringSeparator();
            horizontalSizeOfRenderWorkPlace = parentView.getHorizontalSizeOfRenderWorkPlace();
            horizontalSizeOfRenderWorkPlace = stringSeparator.length() - 2;

            currentOutputPosition = 0;
            //controller.setCategoryModel(parentModel.getCatalogCategory().get(parentView.getCurrentOutputPosition()-1));
//            for (Project elementProject : parentModel.getProject(controller.getCategoryModel())){
            Project elementProject;
            for (int index = 0; index< parentModel.getProject(controller.getCategoryModel()).size(); index++) {
                controller.deviceOut.writeln(stringSeparator);
                elementProject = parentModel.getProject(controller.getCategoryModel()).get(index);
                controller.getDeviceOut().writeln("|" + String.format(" %1$-" + horizontalSizeOfRenderWorkPlace + "s",
                        parentView.getTabIndent(controller.LEVEL_OF_INTERCEPTION_OUTPUT) + "*" + (index+1) + " " + elementProject.name) + "|");
                if (controller.isHaveToExpand(index)){
                    currentOutputPosition = index;
                    if (controller.userChoice.size() >= controller.LEVEL_OF_INTERCEPTION_OUTPUT){
                        controller.deviceOut.write("#project#");
                    }
                }
            }
        //}
        parentController.deviceOut.replace(controller.deviceOut.getAccumulativeMultiLine(true).toString(), "#category#");
    }

    public int getCurrentOutputPosition() {
        return currentOutputPosition;
    }
}
