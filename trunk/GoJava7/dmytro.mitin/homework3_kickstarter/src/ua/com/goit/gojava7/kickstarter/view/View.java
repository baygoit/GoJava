package ua.com.goit.gojava7.kickstarter.view;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.view.exception.ExitException;
import ua.com.goit.gojava7.kickstarter.view.page.Page;

public interface View {
    void run();

    Page updatePageToStandard(String command);

    // implementing Observer pattern
    void handleNotification() throws ExitException;

    void printRandomQuote();

    void printCategories();

    void printProjects(Category category);

    void printProjectInfo(Project project);

    void printProjectDetailedInfo(Project project);
}
