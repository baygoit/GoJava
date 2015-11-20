package ua.com.goit.gojava7.salivon.state;

import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.beans.Project;
import java.util.List;
import ua.com.goit.gojava7.salivon.handlers.ErrorHandlerStateCategory;
import ua.com.goit.gojava7.salivon.context.Console;

public class CategoryState extends State {

    private List<Category> categories = getManagerData().getAllCategories();
    private List<Project> projects = getManagerData().getProjectsOfCategory(State.getIndexCategory());

    public CategoryState() {
        handler = new ErrorHandlerStateCategory(getManagerData());
        menu = "Enter the number of projects to select it.\n"
                + "Enter 0 return to above.\n"
                + "Enter 'q' to exit.\n";

    }

    @Override
    public void outputContentState() {
        int index = State.getIndexCategory();
        System.out.print("Category - ");
        Category cat = categories.get(index - 1);
        System.out.println(cat.getId() + " " + cat.getName() + "\n");
        System.out.println("Projects:");
        for (Project list1 : projects) {
            if (list1.getIdCategory() == index) {
                System.out.println(list1.getId() + " - " + list1.getTitle());
                System.out.println("  Description: " + list1.getDescription());
                System.out.println("  Total " + list1.getTotal() + "$");
                System.out.println("  Collected amount " + list1.getCollectedAmount() + "$");
                System.out.println("  Number of days to end " + list1.getNumberOfDaysToEnd() + "\n");
            }
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
        int inDataToInt = Integer.parseInt(inData);
        if (inDataToInt == 0) {
            context.setCurrentState(new WelcomeState());
        } else {
            State.setIndexProject(inDataToInt);
            context.setCurrentState(new ProjectState());
        }

    }
}
