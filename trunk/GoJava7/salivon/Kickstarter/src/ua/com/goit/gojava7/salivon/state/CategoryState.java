package ua.com.goit.gojava7.salivon.state;

import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.beans.Project;
import java.util.List;
import ua.com.goit.gojava7.salivon.handlers.ErrorHandlerStateCategory;
import ua.com.goit.gojava7.salivon.context.Console;
import static ua.com.goit.gojava7.salivon.state.State.getCurrentDataType;
import ua.com.goit.gojava7.salivon.dao.DaoFactory;

public class CategoryState extends State {

    private Category category = DaoFactory.getCategoryDao(getCurrentDataType()).getCategory(State.getIdCategory());
    private List<Project> projects = DaoFactory.getProjectDao(getCurrentDataType()).getProjectsOfCategory(State.getIdCategory());

    public CategoryState() {
        handler = new ErrorHandlerStateCategory();
        menu = "Enter the number of projects to select it.\n"
                + "Enter 0 return to above.\n"
                + "Enter 'q' to exit.\n";

    }

    @Override
    public void outputContentState() {
        System.out.print("Category - ");
        System.out.println("  " + category.getName() + "\n");
        System.out.println("Projects:");
        int i = 1;
        for (Project list1 : projects) {
            System.out.println(i + " - " + list1.getTitle());
            System.out.println("  Description: " + list1.getDescription());
            System.out.println("  Total " + list1.getTotal() + "$");
            System.out.println("  Collected amount " + list1.getCollectedAmount() + "$");
            System.out.println("  Number of days to end " + list1.getNumberOfDaysToEnd() + "\n");
            i++;
        }
        System.out.println("--------------------------------------------------");
        System.out.println(menu);

    }

    @Override
    public void changeState(Console context) {
        String inData = getInData();
        if (inData.equalsIgnoreCase("q")) {
            performExit();
            return;
        }
        int index = Integer.parseInt(inData);
        if (index == 0) {
            context.setCurrentState(new WelcomeState());
        } else {
            State.setIdProject(convertIndexToId(index));
            context.setCurrentState(new ProjectState());
        }

    }

    protected int convertIndexToId(int index) {
        index--;
        int id = projects.get(index).getId();
        return id;
    }
}
