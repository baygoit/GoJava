package ua.com.goit.gojava7.kickstarter.view.page;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.view.ConsoleView;

/**
 * Created by Dmytro on 07.11.2015.
 */
public class CategoryPage implements Page {
    ConsoleView view;

    Category category;

    public CategoryPage(ConsoleView view, Category category) {
        this.view = view;
        this.category = category;
    }

    @Override
    public void show() {
        view.printProjects(category);

        remindToChoose();
    }

    @Override
    public void remindToChoose() {
        System.out.println("Please choose project number or enter \"h\" for help.");
    }

    @Override
    public Page getUpdated(String command) {
        if (ConsoleView.isStandard(command)) {
            return view.updatePageToStandard(command);
        }
        int code;
        try {
            code = Integer.parseInt(command) - 1;
        } catch (NumberFormatException | NullPointerException e) {
            return new ErrorPage(view);
        }
        Project project = view.getController().getProject(code, category);
        if (project == null) {
            return new ErrorPage(view);
        }
        return new ProjectPage(view, project);
    }
}
