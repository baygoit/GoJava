package KickStarter.view;

import KickStarter.Output;
import KickStarter.controller.CategoryController;
import KickStarter.controller.MainPageController;
import KickStarter.controller.ProjectController;
import KickStarter.controller.ProjectMenuController;
import KickStarter.model.MainPageModel;
import KickStarter.model.Project;

import java.util.Map;

//import static KickStarter.view.ViewProject.ProjectMenuElements;

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

        ProjectController projectController = (ProjectController) controller.getParentController();
        stringSeparator = projectController.viewProject.stringSeparator;
        horizontalSizeOfRenderWorkPlace = projectController.viewProject.horizontalSizeOfRenderWorkPlace;
        Map.Entry menuPosition = getProjectMenuElement(controller);
        Output tempDevice = new Output(System.out);
        if (menuPosition.getKey().toString().equals("INVESTMENT")){
            StringBuilder formattedText = new StringBuilder(getTabIndent(controller.LEVEL_OF_INTERCEPTION_OUTPUT) + "1. Invest  1$ - you will be able to use it during 60 days");
            tempDevice.writeln("|" + String.format(" %1$-" + horizontalSizeOfRenderWorkPlace + "s", formattedText) + "|");
            formattedText = new StringBuilder(getTabIndent(controller.LEVEL_OF_INTERCEPTION_OUTPUT) + "2. Invest 10$ - you will buy limited edition");
            tempDevice.writeln("|" + String.format(" %1$-" + horizontalSizeOfRenderWorkPlace + "s", formattedText) + "|");
            formattedText = new StringBuilder(getTabIndent(controller.LEVEL_OF_INTERCEPTION_OUTPUT) + "3. Invest 40$ - you will buy full edition");
            tempDevice.writeln("|" + String.format(" %1$-" + horizontalSizeOfRenderWorkPlace + "s", formattedText) + "|");
        }
        controller.deviceOut.replace(tempDevice.getAccumulativeMultiLine(true).toString(), "#projectMenu#");
    }


    public Map.Entry getProjectMenuElement(ProjectMenuController controller){
        ProjectController projectController = (ProjectController) controller.getParentController();
        int choiceInProjectMenu = controller.userChoice.get(controller.LEVEL_OF_INTERCEPTION_OUTPUT-2);
        for (Map.Entry elem : projectController.viewProject.projectMenu.entrySet()){
            if ((Integer)elem.getValue() == choiceInProjectMenu){
                return elem;
            }
        }
        throw new RuntimeException("Chosen incorrect element of project menu №:" + choiceInProjectMenu);
    }
    public String getTabIndent(int counter){
        String temp = "";
        for (int i = 0; i < counter; i++) {
            temp += "  ";
        }
        return temp;
    }
}
