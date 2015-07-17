package Lessons1.KickStarter.view;

import Lessons1.KickStarter.controller.CategoryController;
import Lessons1.KickStarter.controller.MainPageController;
import Lessons1.KickStarter.controller.ProjectController;
import Lessons1.KickStarter.model.MainPageModel;
import Lessons1.KickStarter.model.Project;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 14.07.15
 * Time: 14:19
 * @version: 1.0
 */
public class ViewProject {

    private String stringSeparator;
    private int horizontalSizeOfRenderWorkPlace;
//    private int currentOutputPosition;

    public void render(ProjectController controller){

        CategoryController categoryController = (CategoryController)controller.getParentController();
        MainPageController mainController = (MainPageController)categoryController.getParentController();
        ViewMainPage parentView = mainController.viewMainPage;
        MainPageModel parentModel = mainController.mainPageModel;

        //if (Integer.parseInt(controller.userChoice[controller.LEVEL_OF_INTERCEPTION_OUTPUT-2]) == parentView.getCurrentOutputPosition()-1){
            stringSeparator = parentView.getStringSeparator();
            horizontalSizeOfRenderWorkPlace = parentView.getHorizontalSizeOfRenderWorkPlace();
            horizontalSizeOfRenderWorkPlace = stringSeparator.length() - 2;

            Project elementProject = parentModel.getProject(categoryController.getCategoryModel()).get(categoryController.viewCategory.getCurrentOutputPosition()-1);

            horizontalSizeOfRenderWorkPlace = parentView.getStringSeparator().length() - 2;
            StringBuilder formattedText;
            //description
            controller.deviceOut.writeln("[Description]: ");
            formattedText = new StringBuilder();
            formattedText.append(String.format("%1$-100s \n", elementProject.fullDescription));
            formattedText.append(String.format("Pledged amount: %1$-10s \n", elementProject.requirementAmount));
            formattedText.append(String.format("Funded amount: %1$-10s \n", elementProject.balancedAmount));
            formattedText.append(String.format("Days left: %1$-10s \n", elementProject.daysLeft));
            controller.deviceOut.writeln(String.format(" %1$-" + horizontalSizeOfRenderWorkPlace + "s", formattedText));

            //history
            if (elementProject.historyOfProject.size() != 0){
                controller.deviceOut.writeln("[History]: ");
                for (Project.History elemHistory : elementProject.historyOfProject){
                    formattedText = new StringBuilder();
                    formattedText.append(String.format("%1$-50s", elemHistory.description));
                    formattedText.append(String.format("%1$-20s", elemHistory.user));
                    formattedText.append(String.format("%1$-10s", elemHistory.dateAdded));
                    controller.deviceOut.writeln("|" + String.format(" %1$-" + horizontalSizeOfRenderWorkPlace + "s", formattedText) + "|");
                }
            }
            //links
            if (elementProject.demoLink.size() != 0){
                controller.deviceOut.writeln("[Links]: ");
                for (Project.VideoLink elemVideoLink : elementProject.demoLink){
                    formattedText = new StringBuilder();
                    formattedText.append(String.format("%1$-50s", elemVideoLink.description));
                    formattedText.append(String.format("%1$-20s", elemVideoLink.link));
                    controller.deviceOut.writeln("|" + String.format(" %1$-" + horizontalSizeOfRenderWorkPlace + "s", formattedText) + "|");
                }
            }
            //question / answer
            if (elementProject.userQuestion.size() != 0){
                controller.deviceOut.writeln("[Links]: ");
                for (Project.QuestionAnswer elemQuestionAnswer : elementProject.userQuestion){
                    formattedText = new StringBuilder();
                    formattedText.append(String.format("%1$-50s", elemQuestionAnswer.description));
                    formattedText.append(String.format("%1$-20s", elemQuestionAnswer.user));
                    formattedText.append(String.format("%1$-10s", elemQuestionAnswer.dateAdded));
                    controller.deviceOut.writeln("|" + String.format(" %1$-" + horizontalSizeOfRenderWorkPlace + "s", formattedText) + "|");
                }
            }
        //}
    mainController.deviceOut.replace(controller.deviceOut.getAccumulativeMultiLine(true).toString(), "#project#");
    }
}
