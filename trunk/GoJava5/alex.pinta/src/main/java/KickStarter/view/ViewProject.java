package KickStarter.view;

import KickStarter.Output;
import KickStarter.controller.CategoryController;
import KickStarter.controller.MainPageController;
import KickStarter.controller.ProjectController;
import KickStarter.model.MainPageModel;
import KickStarter.model.Project;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 14.07.15
 * Time: 14:19
 * @version: 1.0
 */
public class ViewProject {

    public String stringSeparator;
    public int horizontalSizeOfRenderWorkPlace;
    public enum ProjectMenuElements {INVESTMENT, QUESTION};
    public Map<ProjectMenuElements, Integer> projectMenu  = new EnumMap<ProjectMenuElements, Integer>(ProjectMenuElements.class);

//    private int currentOutputPosition;


    public ViewProject() {
        projectMenu.put(ProjectMenuElements.INVESTMENT, 1);
        projectMenu.put(ProjectMenuElements.QUESTION, 2);
    }

    public void render(ProjectController controller) {

        CategoryController categoryController = (CategoryController) controller.getParentController();
        MainPageController mainController = (MainPageController) categoryController.getParentController();
        ViewMainPage parentView = mainController.viewMainPage;
        MainPageModel parentModel = mainController.mainPageModel;

        stringSeparator = parentView.getStringSeparator();
        horizontalSizeOfRenderWorkPlace = parentView.getHorizontalSizeOfRenderWorkPlace();
        horizontalSizeOfRenderWorkPlace = stringSeparator.length() - 2;

        Project elementProject = parentModel.getProject(categoryController.getCategoryModel()).get(categoryController.viewCategory.getCurrentOutputPosition() - 1);

        horizontalSizeOfRenderWorkPlace = parentView.getStringSeparator().length() - 2;
        StringBuilder formattedText;
        Output tempDevice = new Output(System.out);
        //description
        tempDevice.writeln("[Description]: ");
        formattedText = new StringBuilder();
        formattedText.append(String.format("%1$-100s \n", elementProject.fullDescription));
        formattedText.append(String.format("Pledged amount: %1$-10s \n", elementProject.requirementAmount));
        formattedText.append(String.format("Funded amount: %1$-10s \n", elementProject.balancedAmount));
        formattedText.append(String.format("Days left: %1$-10s \n", elementProject.daysLeft));
        tempDevice.writeln(String.format(" %1$-" + horizontalSizeOfRenderWorkPlace + "s", formattedText));

        //history
        if (elementProject.historyOfProject.size() != 0) {
            tempDevice.writeln("[History]: ");
            for (Project.History elemHistory : elementProject.historyOfProject) {
                formattedText = new StringBuilder();
                formattedText.append(String.format("%1$-70s", elemHistory.description));
                formattedText.append(String.format("%1$-20s", elemHistory.user));
                formattedText.append(String.format("%1$-10s", elemHistory.dateAdded));
                tempDevice.writeln("|" + String.format(" %1$-" + horizontalSizeOfRenderWorkPlace + "s", formattedText) + "|");
            }
        }
        //links
        if (elementProject.demoLink.size() != 0) {
            tempDevice.writeln("[Links]: ");
            for (Project.VideoLink elemVideoLink : elementProject.demoLink) {
                formattedText = new StringBuilder();
                formattedText.append(String.format("%1$-70s", elemVideoLink.description));
                formattedText.append(String.format("%1$-20s", elemVideoLink.link));
                tempDevice.writeln("|" + String.format(" %1$-" + horizontalSizeOfRenderWorkPlace + "s", formattedText) + "|");
            }
        }
        //question / answer
        if (elementProject.userQuestion.size() != 0) {
            tempDevice.writeln("[Question / answer]: ");
            for (Project.QuestionAnswer elemQuestionAnswer : elementProject.userQuestion) {
                formattedText = new StringBuilder();
                formattedText.append(String.format("%1$-70s", elemQuestionAnswer.description));
                formattedText.append(String.format("%1$-20s", elemQuestionAnswer.user));
                formattedText.append(String.format("%1$-10s", elemQuestionAnswer.dateAdded));
                tempDevice.writeln("|" + String.format(" %1$-" + horizontalSizeOfRenderWorkPlace + "s", formattedText) + "|");
            }
        }

        //additional user action
//        formattedText = new StringBuilder(String.format("%1$-70s \n", ""));
//        tempDevice.writeln("|" + String.format(" %1$-" + horizontalSizeOfRenderWorkPlace + "s", formattedText) + "|");
        formattedText = new StringBuilder(String.format("%1$-70s", "[1. Invest in the project]: "));
        tempDevice.writeln("|" + String.format(" %1$-" + horizontalSizeOfRenderWorkPlace + "s", formattedText) + "|");

        if (controller.isHaveToExpand(projectMenu.get(ProjectMenuElements.INVESTMENT))){
            if (controller.userChoice.size() >= controller.LEVEL_OF_INTERCEPTION_OUTPUT){
                tempDevice.write("#projectMenu#");
            }
        }
        formattedText = new StringBuilder(String.format("%1$-70s", "[2. Send question]: "));
        tempDevice.writeln("|" + String.format(" %1$-" + horizontalSizeOfRenderWorkPlace + "s", formattedText) + "|");

        if (controller.isHaveToExpand(projectMenu.get(ProjectMenuElements.QUESTION))){
            if (controller.userChoice.size() >= controller.LEVEL_OF_INTERCEPTION_OUTPUT){
                tempDevice.write("#projectMenu#");
            }
        }

        controller.deviceOut.replace(tempDevice.getAccumulativeMultiLine(true).toString(), "#project#");
    }
}
