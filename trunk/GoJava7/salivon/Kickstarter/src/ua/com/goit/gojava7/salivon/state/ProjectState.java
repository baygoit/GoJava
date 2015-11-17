package ua.com.goit.gojava7.salivon.state;

import java.util.List;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.handlers.ErrorHandlerStateProject;
import ua.com.goit.gojava7.salivon.stores.StoreProjects;
import ua.com.goit.gojava7.salivon.context.Console;

public class ProjectState extends State {

    private List<Project> projects = StoreProjects.getProjects();

    public ProjectState() {
        handler = new ErrorHandlerStateProject();
        menu = "Enter 1 - invest in the project.\n"
                + "Enter 2 - ask a question.\n"
                + "Enter 0 - return to above.\n"
                + "Enter 'q' - to exit.\n";

    }

    @Override
    public void outputContentState() {
        int index = State.getIndexProject() - 1;
        System.out.println("Project");
        Project project = projects.get(index);
        System.out.println(project.getTitle());
        System.out.println("  Description: " + project.getDescription());
        System.out.println("  Total " + project.getTotal() + "$");
        System.out.println("  Collected amount " + project.getCollectedAmount() + "$");
        System.out.println("  Number of days to end " + project.getNumberOfDaysToEnd());
        System.out.println("  History " + project.getHistoryProject());
        System.out.println("  Link " + project.getLink());
        System.out.println("  FAQ " + project.getFaq() + "\n");
        System.out.println("--------------------------------------------------\n");
        System.out.println(menu);
    }

    @Override
    protected void changeState(Console context, String inData) {
        int inDateToInt = Integer.parseInt(inData);
        if (inDateToInt == 0) {
            context.setCurrentState(new CategoryState());
        } else if (inDateToInt == 1) {
            context.setCurrentState(new NameInvestState());
        } else if (inDateToInt == 2) {
            context.setCurrentState(new QuestionState());
        }
    }

}
