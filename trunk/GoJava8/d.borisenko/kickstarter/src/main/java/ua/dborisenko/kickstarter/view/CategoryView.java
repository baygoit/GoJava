package ua.dborisenko.kickstarter.view;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Project;

public class CategoryView extends View {

    public static final String INPUT_TO_RETURN = "0";

    public void showContent(Category category) {
        addContentString(HEADER_BLOCK);
        addContentString("Category: " + category.getName());
        addContentString("Projects:");
        addContentString(SOLID_LINE);
        Project project;
        for (int i = 0; i < category.getProjectsCount(); i++) {
            project = category.getProjectByIndex(i);
            addContentString(((i + 1) + ": " + project.getName() + " (collected: " + project.getCollectedSum() + "/"
                    + project.getRequiredSum() + ")"));
            addContentString(project.getDescription());
        }
        addContentString(SOLID_LINE);
        addContentString("Enter project number or \"" + INPUT_TO_RETURN + "\" to return:");
        ioHandler.writeMessage(content.toString());
    }
}
